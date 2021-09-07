plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = Java.compileVersion
    targetCompatibility = Java.compileVersion
}

dependencies {
    implementation(Kotlin.kotlinStdLib)

    testImplementation(Testing.junit)
    testImplementation(Testing.mockk)
    testImplementation(Testing.kotlinCoroutines)
}