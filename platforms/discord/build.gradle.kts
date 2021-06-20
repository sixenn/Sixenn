@file:Suppress("PropertyName")

plugins {
    kotlin("kapt")
}

val kord_version: String by project
val kordx_commands_version: String by project

dependencies {
    implementation("dev.kord:kord-core:$kord_version")
    implementation("dev.kord.x:commands-runtime-kord:$kordx_commands_version")
    kapt("dev.kord.x:commands-processor:$kordx_commands_version")
}