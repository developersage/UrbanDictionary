package com.sangdo.feature.di

import com.google.android.gms.ads.AdRequest
import com.sangdo.feature.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class FeatureModule {
    @Provides
    fun provideAdRequest() = AdRequest.Builder()
        .addKeyword("urban dictionary")
        .addKeyword("dictionary")
        .build()

    @Provides
    @AdUnitId
    fun provideAdUnitID() = BuildConfig.AdUnitId
}