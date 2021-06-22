@file:Suppress("PropertyName")

plugins {
    kotlin("multiplatform") version "1.5.10"
    kotlin("plugin.serialization") version "1.5.0"
}

val coroutines_version: String by project
val datetime_version: String by project
val config4k_version: String by project

allprojects {
    apply(plugin = "org.jetbrains.kotlin.multiplatform")
    apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

    repositories {
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
        maven(url = "https://maven.kotlindiscord.com/repository/maven-public/")
        mavenCentral()
    }

    kotlin {
        jvm {
            compilations.all {
                kotlinOptions {
                    jvmTarget = "13"
                    freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
                }
            }
        }
        js {
            browser()
        }
        val hostOs = System.getProperty("os.name")
        val isMingwX64 = hostOs.startsWith("Windows")
        val nativeTarget = when {
            hostOs == "Mac OS X" -> macosX64("native")
            hostOs == "Linux" -> linuxX64("native")
            isMingwX64 -> mingwX64("native")
            else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
        }
        val commonMain by sourceSets.getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:$datetime_version")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
            }
        }
        val jvmMain by sourceSets.getting {
            dependencies {
                implementation("io.github.config4k:config4k:$config4k_version")
            }
        }
    }
}