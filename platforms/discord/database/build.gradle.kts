@file:Suppress("PropertyName")

val exposed_version: String by project
val hikaricp_version: String by project
val postgre_jdbc_version: String by project

kotlin {
    val jvmMain by sourceSets.getting {
        dependencies {
            api("org.jetbrains.exposed:exposed-core:$exposed_version")
            api("org.jetbrains.exposed:exposed-dao:$exposed_version")
            api("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
            api("org.jetbrains.exposed:exposed-java-time:$exposed_version")
            api("com.zaxxer:HikariCP:$hikaricp_version")
            api("org.postgresql:postgresql:$postgre_jdbc_version")
            api("pw.forst:exposed-upsert:1.1.0")
            api(project(":platforms:discord:common"))
        }
    }
}