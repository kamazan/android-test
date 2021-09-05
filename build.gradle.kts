// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        set("kotlin_version", Kotlin.version)
    }
    val kotlin_version by extra("1.5.21")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Android.gradleTools)
        classpath(Kotlin.gradlePlugin)
        classpath(DaggerHilt.gradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")

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