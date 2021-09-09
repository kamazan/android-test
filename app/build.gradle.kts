import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
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

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
}

dependencies {

    // Feature modules
    implementation(project(":data"))
    implementation(project(":common:data"))
    implementation(project(":common:presentation"))
    implementation(project(":feature:destinations_list:data"))
    implementation(project(":feature:destinations_list:domain"))
    implementation(project(":feature:destinations_list:presentation"))
    implementation(project(":feature:destination_details:data"))
    implementation(project(":feature:destination_details:domain"))
    implementation(project(":feature:destination_details:presentation"))

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

    // Jetpack Navigation
    implementation(Navigation.navigationFragment)
    implementation(Navigation.navigationUi)
}