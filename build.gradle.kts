import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    extra.apply {
        set("compose_version", "1.1.0-beta01")
    }
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
    }
}

plugins {
    id("com.android.application") version "7.2.0-beta02" apply false
    id("com.android.library") version "7.2.0-beta02" apply false
    id("org.jetbrains.kotlin.android") version "1.5.31" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}