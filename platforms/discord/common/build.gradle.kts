@file:Suppress("PropertyName")

val kord_version: String by project

kotlin {
    val commonMain by sourceSets.getting {
        dependencies {
            implementation("dev.kord:kord-common:$kord_version")
        }
    }
}