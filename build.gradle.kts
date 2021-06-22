@file:Suppress("PropertyName")

plugins {
    kotlin("multiplatform") version "1.5.10"
    kotlin("plugin.serialization") version "1.5.0"
    id("org.ajoberstar.grgit") version "4.1.0"
}

val coroutines_version: String by project
val datetime_version: String by project
val config4k_version: String by project

allprojects {
    apply(plugin = "org.jetbrains.kotlin.multiplatform")
    apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
    apply(plugin = "org.ajoberstar.grgit")

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
    base {
        val versionMetadata: String by lazy {
            with(System.getenv("GITHUB_RUN_NUMBER")) {
                if (this != null) return@lazy "build.$this"
            }
            val id = with(grgit.head().abbreviatedId) {
                if (!grgit.status().isClean) "$this-dirty" else this
            }
            "rev.$id"
        }
        val projectName = if (project.name == "sixenn") "sixenn-root" else "sixenn-${project.name}"
        archivesName.set("$projectName-$versionMetadata")
    }
}