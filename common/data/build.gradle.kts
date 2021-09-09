plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Sdk.compileSdk)
    buildToolsVersion(Sdk.buildTools)

    defaultConfig {
        minSdkVersion(Sdk.minSdk)
        targetSdkVersion(Sdk.targetSdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = Testing.testInstrumentationRunner

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = Java.compileVersion
        targetCompatibility = Java.compileVersion
    }
    kotlinOptions {
        jvmTarget = Java.version
    }
    packagingOptions {
        exclude("META-INF/data_debug.kotlin_module")
    }
}

dependencies {

    implementation(project(":data"))

    implementation(Kotlin.kotlinStdLib)
    implementation(Android.coreKtx)
    implementation(Android.appcompat)

    testImplementation(Testing.junit)
    testImplementation(Testing.mockk)
    testImplementation(Testing.kotlinCoroutines)
    androidTestImplementation(Testing.junitAndroid)
    androidTestImplementation(Testing.espressoCore)

    // Dagger Hilt
    implementation(DaggerHilt.android)
    kapt(DaggerHilt.compiler)
}
