import dev.nekkan.sixenn.composite.BuildScriptDependencies

plugins {
    id("sixenn-composite-build")
}

dependencies {
    api(BuildScriptDependencies.Platform.Discord.Core)
    api(BuildScriptDependencies.Platform.Discord.InteraKTions)
}
