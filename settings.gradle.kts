rootProject.name = "Sixenn"

// External builds that helps in the development.
// We should use it instead of the common buildSrc because it does not compile everything if you change something.
includeBuild("composite")

// Each sub-project should be included in the settings file.
include(
    "command-api",
    "commands-platform-common",
    "rest-api",
    "platforms:common",
    "platforms:discord",
    "platforms:discord:interactions",
    "platforms:discord:gateway",
    "platforms:discord:services",
    "platforms:guilded", // todo
    "platforms:twitter", // todo
    "minigames",
    "minigames-platform:discord",
    "locale"
)
