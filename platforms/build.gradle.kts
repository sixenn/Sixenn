val groupName = "${project.group}.platforms.discord"
group = groupName

subprojects {
    group = groupName
    kotlin {
        val commonMain by sourceSets.getting {
            dependencies {
                api(project(":common"))
                api(project(":locale"))
                api(project(":commands"))
            }
        }
    }
}