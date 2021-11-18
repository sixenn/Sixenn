import dev.nekkan.sixenn.composite.BuildScriptDependencies
import dev.nekkan.sixenn.composite.BuildScriptRepositories

plugins {
    id("sixenn-composite-build")
}

allprojects {
    repositories {
        maven(url = BuildScriptRepositories.PerfectDreams)
    }
    dependencies {
        implementation(BuildScriptDependencies.Platform.Discord.Common)
        implementation(BuildScriptDependencies.Platform.Discord.Emoji)
        api(project(":config"))
    }
}
