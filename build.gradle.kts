// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrain.kotlin) apply false
    alias(libs.plugins.google.hilt) apply false
    alias(libs.plugins.google.crashlytics) apply false
    alias(libs.plugins.google.services) apply false
}
