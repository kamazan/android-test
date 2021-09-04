object Sdk {
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
    const val buildTools = "30.0.2"
}

object Java {
    const val version = "1.8"
    val compileVersion = org.gradle.api.JavaVersion.VERSION_1_8
}

object Kotlin {
    const val version = "1.4.32"

    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
}

object Android {
    const val gradleTools = "com.android.tools.build:gradle:4.1.1"
    const val coreKtx = "androidx.core:core-ktx:1.5.0"
    const val appcompat = "androidx.appcompat:appcompat:1.3.0"
}

object Testing {
    const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
    const val junit = "junit:junit:4.+"
    const val junitAndroid = "androidx.test.ext:junit:1.1.2"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object UI {
    const val material = "com.google.android.material:material:1.3.0"
}