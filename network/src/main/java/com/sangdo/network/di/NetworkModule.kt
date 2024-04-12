package com.sangdo.network.di

import com.sangdo.network.UrbanDictionaryClient
import com.sangdo.network.UrbanDictionaryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideUrbanDictionaryService(
        @RapidAPIBaseURL baseUrl: String,
    ): UrbanDictionaryService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(UrbanDictionaryService::class.java)

    @Provides
    fun provideUrbanDictionaryClient(service: UrbanDictionaryService) =
        UrbanDictionaryClient(service)

}