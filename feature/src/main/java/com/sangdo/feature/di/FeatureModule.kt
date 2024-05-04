package com.sangdo.feature.di

import com.google.android.gms.ads.AdRequest
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FeatureModule {
    @Provides
    @Singleton
    fun provideAdRequest() = AdRequest.Builder()
        .addKeyword("urban dictionary")
        .addKeyword("dictionary")
        .build()
}