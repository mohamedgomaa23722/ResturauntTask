package com.gomaa.resturanttask.di.Modules

import com.gomaa.resturanttask.Utils.Constants.BASE_URL
import com.gomaa.resturanttask.di.annotations.AuthApiService
import com.gomaa.resturanttask.di.annotations.AuthInterceptorOkHttpClient
import com.gomaa.resturanttask.network.ServiceApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun moshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @AuthApiService
    @Provides
    @Singleton
    fun ProvideApiService(
        @AuthInterceptorOkHttpClient okHttpClient: OkHttpClient
    ): ServiceApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build().create(ServiceApi::class.java)
    }

}