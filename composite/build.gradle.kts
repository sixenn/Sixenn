plugins {
     kotlin("jvm") version "1.6.0"
     `java-gradle-plugin`
}

repositories {
     mavenCentral()
}

gradlePlugin {
     plugins.register("sixenn-composite-build") {
          id = "sixenn-composite-build"
          implementationClass = "dev.nekkan.sixenn.composite.CompositeBuildPlugin"
     }
}
