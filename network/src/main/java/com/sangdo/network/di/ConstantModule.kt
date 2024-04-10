package com.sangdo.network.di

import com.sangdo.network.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ConstantModule {

    @Provides
    @UrbanDictionaryURL
    fun provideUrbanDictionaryBaseURL() = BuildConfig.URBAN_API_Host

    @Provides
    @UrbanDictionaryKEY
    fun provideUrbanDictionaryAPIKey() = BuildConfig.URBAN_API_Key

    @Provides
    @AuthHeader
    fun provideRapidHeaderMap(
        @UrbanDictionaryKEY rapidAPIKey: String,
        @UrbanDictionaryURL rapidAPIHost: String,
    ) = mapOf(
        "X-RapidAPI-Key" to rapidAPIKey,
        "X-RapidAPI-Host" to rapidAPIHost
    )
}