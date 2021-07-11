rootProject.name = "sixenn"

include(
    ":common",
    ":commands",
    ":platforms:discord:common",
    ":platforms:discord:database",
    ":platforms:discord:services",
    ":platforms:discord:rest",
    ":platforms:discord:gateway",
    ":platforms:discord:interactions",
    ":minigames:common",
    ":minigames:core",
    ":locale",
    ":minecraft"
)
