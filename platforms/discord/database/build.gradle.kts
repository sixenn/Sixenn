val exposed_version: String by project

kotlin {
    val jvmMain by sourceSets.getting {
        dependencies {
            implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
            implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
            implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
        }
    }
}