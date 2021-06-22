rootProject.name = "sixenn"

include(
    ":common",
    ":commands",
    ":platforms:discord:core",
    ":platforms:discord:database",
    ":platforms:discord:services",
    ":platforms:discord:rest",
    ":minigames:common",
    ":minigames:core",
    ":locale",
)
