import java.util.Properties

plugins {
    kotlin("kapt")
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrain.kotlin)
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

        buildConfigField("String", "X_RapidAPI_Key", property.getProperty("X-RapidAPI-Key"))
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core)
    // implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0")) is this needed?
    implementation(libs.androidx.appCompat)

    kapt(libs.kapt.hilt)
    implementation(libs.google.hilt)

    implementation(platform(libs.okhttp.bom))
    implementation(libs.bundles.network)

    testImplementation(libs.junit)
}