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
    const val coroutinesVersion = "1.5.2"

    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
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
    const val androidCore = "androidx.arch.core:core-testing:2.1.0"
    const val mockk = "io.mockk:mockk:1.12.0"
    const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Kotlin.coroutinesVersion}"
}

object UI {
    const val material = "com.google.android.material:material:1.3.0"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
    const val coil = "io.coil-kt:coil:1.2.1"
}

object DaggerHilt {
    private const val version = "2.38.1"

    const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    const val android = "com.google.dagger:hilt-android:$version"
    const val compiler = "com.google.dagger:hilt-compiler:$version"
}

object Navigation {
    private const val version = "2.3.5"

    const val safeArgsGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$version"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:$version"
}