plugins {
    id("org.springframework.boot") version "2.5.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("plugin.spring") version "1.5.20"
}

java.sourceCompatibility = JavaVersion.VERSION_11

kotlin {
    val jvmMain by sourceSets.getting {
        dependencies {
            implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
            implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
            implementation("org.springframework.boot:spring-boot-starter-data-rest")
            implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
            implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
            implementation("org.springframework.boot:spring-boot-starter-security")
            implementation("org.springframework.boot:spring-boot-starter-webflux")
            implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
            implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
            implementation("org.jetbrains.kotlin:kotlin-reflect")
            implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
            runtimeOnly("io.r2dbc:r2dbc-postgresql")
            runtimeOnly("org.postgresql:postgresql")
            api(project(":platforms:discord:common"))
        }
    }
    val jvmTest by sourceSets.getting {
        dependencies {
            implementation("org.springframework.boot:spring-boot-starter-test")
            implementation("io.projectreactor:reactor-test")
            implementation("org.springframework.security:spring-security-test")
        }
    }
}
tasks.withType<Test> {
    useJUnitPlatform()
}

