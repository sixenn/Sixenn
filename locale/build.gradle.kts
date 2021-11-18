import dev.nekkan.sixenn.composite.BuildScriptDependencies
import dev.nekkan.sixenn.composite.BuildScriptRepositories

plugins {
    id("sixenn-composite-build")
    id("net.perfectdreams.i18nhelper.plugin") version "0.0.2-SNAPSHOT"
}

/*i18nHelper {
    generatedPackage.set("dev.nekkan.sixenn.locale")
    languageSourceFolder.set("../config/")
}*/

repositories {
    maven(url = BuildScriptRepositories.PerfectDreams)
}

dependencies {
    api(BuildScriptDependencies.I18nHelper)
    api(BuildScriptDependencies.SerializationKaml)
}

tasks.build {
    dependsOn(tasks.generateI18nKeys)
}

sourceSets["main"].java.srcDir("build/generated/languages")