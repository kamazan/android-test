import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Sdk.compileSdk)
    buildToolsVersion(Sdk.buildTools)

    defaultConfig {
        applicationId = "com.evaneos.evaneostest"
        minSdkVersion(Sdk.minSdk)
        targetSdkVersion(Sdk.targetSdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = Testing.testInstrumentationRunner
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
}

dependencies {

    implementation(Kotlin.kotlinStdLib)
    implementation(Android.coreKtx)
    implementation(Android.appcompat)
    implementation(UI.material)
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    testImplementation(Testing.junit)
    androidTestImplementation(Testing.junitAndroid)
    androidTestImplementation(Testing.espressoCore)

    // Dagger Hilt
    implementation(DaggerHilt.android)
    kapt(DaggerHilt.compiler)
}