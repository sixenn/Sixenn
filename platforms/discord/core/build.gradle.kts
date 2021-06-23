@file:Suppress("PropertyName")

plugins {
    kotlin("kapt")
}

val kord_version: String by project
val kordx_commands_version: String by project
val kordx_emoji_version: String by project

kotlin {
    val jvmMain by sourceSets.getting {
        dependencies {
            implementation("dev.kord:kord-core:$kord_version")
            implementation("dev.kord.x:commands-runtime-kord:$kordx_commands_version")
            implementation("dev.kord.x:emoji:$kordx_emoji_version")
            configurations["kapt"].dependencies.add(project.dependencies.create("dev.kord.x:commands-processor:$kordx_commands_version"))
            api(project(":platforms:discord:common"))
        }
    }
}
