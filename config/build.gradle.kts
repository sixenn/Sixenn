import dev.nekkan.sixenn.composite.BuildScriptDependencies

plugins {
    id("sixenn-composite-build")
}

dependencies {
    api(BuildScriptDependencies.SerializationKaml)
}

