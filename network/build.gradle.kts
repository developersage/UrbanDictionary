import java.util.Properties

plugins {
    kotlin("kapt")
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin)
    alias(libs.plugins.google.hilt)
}

val property = Properties()
    .apply { load(project.rootProject.file("apikeys.properties").inputStream()) }

android {
    namespace = "com.sangdo.network"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildFeatures.buildConfig = true

        buildConfigField("String", "URBAN_API_Key", property.getProperty("X-RapidAPI-Key"))
        buildConfigField("String", "URBAN_API_Host", "\"mashape-community-urban-dictionary.p.rapidapi.com\"")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    kapt(libs.kapt.hilt)
    implementation(libs.google.hilt)

    implementation(libs.bundles.androidx.core)

    kapt(libs.kapt.moshi)
    implementation(platform(libs.okhttp.bom))
    implementation(libs.bundles.network)

    testImplementation(libs.junit)
}