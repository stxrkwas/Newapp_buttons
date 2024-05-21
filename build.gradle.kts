// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {

    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

    /* Mudados para:
    id("com.android.application") version "8.4.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false*/
}