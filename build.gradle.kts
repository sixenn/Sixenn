import dev.nekkan.sixenn.composite.BuildScriptDependencies
import dev.nekkan.sixenn.composite.BuildScriptRepositories
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("sixenn-composite-build")
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.serialization") version "1.6.0"
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("org.ajoberstar.grgit") version "4.1.0"
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
    apply(plugin = "com.github.johnrengelman.shadow")
    apply(plugin = "org.ajoberstar.grgit")

    repositories {
        mavenCentral()
        maven(url = BuildScriptRepositories.Sonatype)
    }

    // Setup common dependencies that would be used in each project.
    dependencies {
        api(BuildScriptDependencies.Kotlin.Coroutines)
        api(BuildScriptDependencies.Kotlin.Serialization)
    }

    fun getGitBuild() = with(System.getenv("GITHUB_RUN_NUMBER")) { if (this != null) "build.$this" else this }
        ?: "rev.${if (!grgit.status().isClean) "${grgit.head().abbreviatedId}-dirty" else grgit.head().abbreviatedId}"

    tasks {
        test {
            useJUnitPlatform()
        }
        shadowJar {
            minimize()
            val path = project.path.replace(":", "-").removePrefix("-")
            if (path.isNotEmpty()) {
                archiveBaseName.set("sixenn-$path-${getGitBuild()}")
            } else {
                archiveBaseName.set("sixenn-root-${getGitBuild()}") // why you would want to do this?
            }
            from(rootProject.file("licenses"))
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }
}
