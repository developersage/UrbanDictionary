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
    @RapidAPIBaseURL
    fun provideRapidAPIBaseURL() = "https://" + BuildConfig.URBAN_API_Host

    @Provides
    @UrbanDictionaryHOST
    fun provideUrbanDictionaryHost() = BuildConfig.URBAN_API_Host

    @Provides
    @UrbanDictionaryKEY
    fun provideUrbanDictionaryAPIKey() = BuildConfig.URBAN_API_Key

    @Provides
    @AuthHeader
    fun provideRapidHeaderMap(
        @UrbanDictionaryKEY rapidAPIKey: String,
        @UrbanDictionaryHOST rapidAPIHost: String,
    ) = mapOf(
        "X-RapidAPI-Host" to rapidAPIHost,
        "X-RapidAPI-Key" to rapidAPIKey,
    )
}