// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        set("kotlin_version", Kotlin.version)
    }
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Android.gradleTools)
        classpath(Kotlin.gradlePlugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks {
    val clean by registering(Delete::class)
}