plugins {
    id("net.minecrell.plugin-yml.bukkit") version "0.4.0"
    id("me.bristermitten.pdm") version "0.0.28"
}

bukkit {
    main = "dev.nekkan.sixenn.minecraft.SixennBukkitPlugin"
    authors = listOf("nekkan")
    version = project.version.toString()
    apiVersion = "1.17"
}

repositories {
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

kotlin {
    val jvmMain by sourceSets.getting {
        dependencies {
            compileOnly("org.spigotmc:spigot-api:1.17-R0.1-SNAPSHOT")
        }
    }
}

tasks.withType(Jar::class) {
    dependsOn(tasks.pdm)
}
