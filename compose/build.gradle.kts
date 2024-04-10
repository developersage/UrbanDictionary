plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.sangdo.compose"
    compileSdk = libs.versions.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}