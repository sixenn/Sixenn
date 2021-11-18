rootProject.name = "Sixenn"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.perfectdreams.net/")
    }
}

// External builds that helps in the development.
// We should use it instead of the common buildSrc because it does not compile everything if you change something.
includeBuild("composite")

// Each sub-project should be included in the settings file.
include(
    "commands-platform-api",
    "commands-platform-common",
    "rest-api-common",
    "platforms:common",
    "platforms:discord",
    "platforms:discord:interactions",
    "platforms:discord:gateway",
    "platforms:discord:services",
    "platforms:discord:rest-api",
    "platforms:guilded", // todo
    "platforms:twitter", // todo
    "minigames-platform:discord",
    "config",
    "locale"
)
