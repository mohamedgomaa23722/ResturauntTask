package com.gomaa.resturanttask.Utils

import android.annotation.SuppressLint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.lang.Exception
import java.lang.RuntimeException
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.*

/**
 * initialize looger for logging Body_Level
 */
val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

/**
 * build our ok http client and pass header into it
 */
val  okHttp = getUnsafeOkHttpClient().addInterceptor(logger).addInterceptor {
    val Request = it.request().newBuilder().addHeader("lang", "en").build()
    it.proceed(Request)
}.build()

/**
 * This fun is not secured help us to use nonConfig or missing ssl from server side
 * it may cause problems for users and We need To notify backend to solve that problem
 * by looking certification key !!
 */
fun getUnsafeOkHttpClient(): OkHttpClient.Builder {
    return try {
        // Create a trust manager that does not validate certificate chains
        val trustAllCerts = arrayOf<TrustManager>(
            @SuppressLint("CustomX509TrustManager")
            object : X509TrustManager {
                @SuppressLint("TrustAllX509TrustManager")
                @Throws(CertificateException::class)
                override fun checkClientTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }

                @SuppressLint("TrustAllX509TrustManager")
                @Throws(CertificateException::class)
                override fun checkServerTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            }
        )

        // Install the all-trusting trust manager
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, SecureRandom())

        // Create an ssl socket factory with our all-trusting manager
        val sslSocketFactory: SSLSocketFactory = sslContext.socketFactory
        val builder = OkHttpClient.Builder()
        builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
        builder.hostnameVerifier(object : HostnameVerifier {
            @SuppressLint("BadHostnameVerifier")
            override fun verify(hostname: String?, session: SSLSession?): Boolean {
                return true
            }
        })
        builder
    } catch (e: Exception) {
        throw RuntimeException(e)
    }
}