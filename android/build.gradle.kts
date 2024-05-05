import com.android.build.api.dsl.Packaging
import java.util.Properties

plugins {
    kotlin("kapt")
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin)
    alias(libs.plugins.google.services)
    alias(libs.plugins.google.crashlytics)
    alias(libs.plugins.google.hilt)
}

val property = Properties()
    .apply { load(project.rootProject.file("apikeys.properties").inputStream()) }

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

        resValue("string", "AdUnitId", property.getProperty("Ad-Unit-ID"))
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

    implementation(project(":feature"))

    kapt(libs.kapt.hilt)
    implementation(libs.google.hilt)

    implementation(libs.google.ads)

    implementation(platform(libs.google.bom))
    implementation(libs.bundles.google)

    implementation(libs.bundles.androidx)
    implementation(libs.bundles.androidx.core)

    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.junitBundle)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.test.junit)
    debugImplementation(libs.bundles.composeTest)
}