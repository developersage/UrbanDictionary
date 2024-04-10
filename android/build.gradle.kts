import com.android.build.api.dsl.Packaging

plugins {
    kotlin("kapt")
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin)
    alias(libs.plugins.google.services)
    alias(libs.plugins.google.crashlytics)
    alias(libs.plugins.google.hilt)
}

android {
    namespace = "com.sangdo.urban"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.sangdo.urban"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables { useSupportLibrary = true }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
    kapt { correctErrorTypes = true }
    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = "1.5.0" }

    fun Packaging.packaging() {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

dependencies {

    implementation(project(":repository"))
    implementation(project(":feature"))

    implementation(libs.google.ads)

    implementation(platform(libs.google.bom))
    implementation(libs.bundles.google)

    implementation(libs.androidx.core)
    implementation(libs.bundles.androidx)

    kapt(libs.kapt.hilt)
    implementation(libs.google.hilt)

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.junitBundle)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.test.junit)
    debugImplementation(libs.bundles.composeTest)
}