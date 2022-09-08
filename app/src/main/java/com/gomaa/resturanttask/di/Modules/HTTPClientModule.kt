package com.gomaa.resturanttask.di.Modules

import com.gomaa.resturanttask.Utils.okHttp
import com.gomaa.resturanttask.di.annotations.AuthInterceptorOkHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HTTPClientModule {
    @AuthInterceptorOkHttpClient
    @Provides
    @Singleton
    fun provideAuthInterceptorOkHttpClient(): OkHttpClient {
        return okHttp
    }
}