plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrain.kotlin)
}

android {
    namespace = "com.sangdo.network"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    testImplementation(libs.junit)
}