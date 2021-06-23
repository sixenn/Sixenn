@file:Suppress("PropertyName")

val okio_version: String by project
val snakeyaml_version: String by project

kotlin {
    sourceSets {
        all {
            languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
            languageSettings.useExperimentalAnnotation("okio.ExperimentalFileSystem")
        }
        val commonMain by getting {
            dependencies {
                api(project(":common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                api("org.yaml:snakeyaml:$snakeyaml_version")
            }
        }
    }
}
