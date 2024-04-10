package com.sangdo.network.module

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
    @AuthHeader
    fun provideRapidHeaderMap(
        rapidAPIKey: String = BuildConfig.URBAN_API_Key,
        @UrbanDictionaryURL rapidAPIHost: String,
    ) = mapOf(
        "X-RapidAPI-Key" to rapidAPIKey,
        "X-RapidAPI-Host" to rapidAPIHost
    )
}