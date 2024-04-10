package com.sangdo.network.module

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Reusable
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
    @Reusable
    @RapidOkHttpClient
    fun provideOkHttpClient(
        @HeaderInterceptor headerInterceptor: Interceptor,
        loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .addNetworkInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Reusable
    fun provideUrbanDictionaryService(
        @UrbanDictionaryURL baseUrl: String,
        @RapidOkHttpClient okHttpClient: OkHttpClient
    ): UrbanDictionaryService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(UrbanDictionaryService::class.java)

}