package com.gomaa.resturanttask.di.Modules

import com.gomaa.resturanttask.Utils.getUnsafeOkHttpClient
import com.gomaa.resturanttask.Utils.logger
import com.gomaa.resturanttask.di.annotations.AuthBody
import com.gomaa.resturanttask.di.annotations.AuthInterceptorOkHttpClientGet
import com.gomaa.resturanttask.di.annotations.AuthInterceptorOkHttpClientPost
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HTTPClientModule {
    /**
     * at this we need to provide OkHttpClient for Post HTTP with passing body and
     * header
     */
    @AuthInterceptorOkHttpClientPost
    @Provides
    @Singleton
    fun provideAuthInterceptorOkHttpClientPost(@AuthBody body:RequestBody): OkHttpClient {
       return getUnsafeOkHttpClient().addInterceptor(logger).addInterceptor {
            val Request = it.request().newBuilder().addHeader("lang", "en").post(body).build()
            it.proceed(Request)
        }.build()
    }

    /**
     * at this we need to provide OkHttpClient for Post HTTP with passing
     * header only
     */
    @AuthInterceptorOkHttpClientGet
    @Provides
    @Singleton
    fun provideAuthInterceptorOkHttpClientGet(): OkHttpClient {
        return getUnsafeOkHttpClient().addInterceptor(logger).addInterceptor {
            val Request = it.request().newBuilder().addHeader("lang", "en").build()
            it.proceed(Request)
        }.build()
    }
}