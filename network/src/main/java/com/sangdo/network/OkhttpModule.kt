package com.sangdo.network

import com.sangdo.network.di.AuthHeader
import com.sangdo.network.di.HeaderInterceptor
import com.sangdo.network.di.RapidOkHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor

/** Currently not in used */
@Module
@InstallIn(SingletonComponent::class)
class OkhttpModule {

    @Provides
    fun provideLoggingInterceptor() = HttpLoggingInterceptor()

    @Provides
    @HeaderInterceptor
    fun provideHeaderInterceptor(
        @AuthHeader authHeader: Map<String, String>
    ): Interceptor = Interceptor { chain ->
        chain.proceed(
            Request.Builder().run {
                authHeader.forEach { (key, value) -> addHeader(key, value) }
                build()
            }
        )
    }

    @Provides
    @RapidOkHttpClient
    fun provideOkHttpClient(
        @HeaderInterceptor headerInterceptor: Interceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(headerInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()
}