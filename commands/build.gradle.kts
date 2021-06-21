kotlin {
    val commonMain by sourceSets.getting {
        dependencies {
            api(project(":common"))
        }
    }
}
