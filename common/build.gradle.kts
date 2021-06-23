kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api("io.github.microutils:kotlin-logging:2.0.8")
            }
        }
        val jvmMain by getting {
            dependencies {
                api("io.github.microutils:kotlin-logging-jvm:2.0.8")
            }
        }
    }
}