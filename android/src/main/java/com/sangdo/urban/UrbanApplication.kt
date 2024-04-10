package com.sangdo.urban

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UrbanApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        
    }
}