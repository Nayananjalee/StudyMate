// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0-RC2" apply false
}
buildscript {
    dependencies {
        classpath ("com.android.tools.build:gradle:7.2.0")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
    }
}