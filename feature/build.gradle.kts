import java.util.Properties

plugins {
    kotlin("kapt")
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin)
    alias(libs.plugins.google.services)
    alias(libs.plugins.google.crashlytics)
    alias(libs.plugins.google.hilt)
}

val property = Properties()
    .apply { load(project.rootProject.file("apikeys.properties").inputStream()) }

android {
    namespace = "com.sangdo.feature"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        vectorDrawables { useSupportLibrary = true }
        buildFeatures.buildConfig = true

        buildConfigField("String", "AdUnitId", property.getProperty("Ad-Unit-ID"))
    }

    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = "1.5.0" }
    kotlinOptions { jvmTarget = "17" }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {

    implementation(project(":repository"))

    kapt(libs.kapt.hilt)
    implementation(libs.google.hilt)

    implementation(libs.google.ads)

    implementation(libs.bundles.androidx)
    implementation(libs.bundles.androidx.core)

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)

    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.test.junit)
    debugImplementation(libs.bundles.composeTest)
}