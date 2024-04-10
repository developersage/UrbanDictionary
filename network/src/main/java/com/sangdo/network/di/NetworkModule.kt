package com.sangdo.network.di

import com.sangdo.network.UrbanDictionaryService
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
        .addInterceptor(headerInterceptor)
        .addNetworkInterceptor(loggingInterceptor)
        .build()

    @Provides
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