plugins {
    id("com.android.library")
    id("kotlin-android")
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
}

dependencies {

    implementation(Kotlin.kotlinStdLib)
    implementation(Android.coreKtx)
    implementation(Android.appcompat)
    implementation(UI.material)

    testImplementation(Testing.junit)
    androidTestImplementation(Testing.junitAndroid)
    androidTestImplementation(Testing.espressoCore)
}
