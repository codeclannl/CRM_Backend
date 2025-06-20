import org.gradle.internal.declarativedsl.parsing.main

plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.spring") version "2.0.21"

    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
    id ("com.google.cloud.tools.jib") version "3.4.5"
}

group = "nl.codeclan"
version = "0.0.1-SNAPSHOT"

var jibImageUrl = "registry.hub.docker.com/gorgyra/crm-backend:1.0.2"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql:42.7.5")
    implementation("org.hibernate.common:hibernate-commons-annotations:6.0.6.Final")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("jakarta.validation:jakarta.validation-api")

    implementation("org.slf4j:slf4j-api:2.0.16")
    implementation("ch.qos.logback:logback-classic:1.5.16")
    implementation("ch.qos.logback:logback-core:1.5.16")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

jib {
    extraDirectories {}

    from {
        image = "amazoncorretto:21-alpine-jdk"
    }
    to {
        image =  jibImageUrl
        auth {
            username = "docker@gorgyra.com" // Defined in 'gradle.properties'.
            password = "WheM1cVPwtAH4Dx7kjLu"
        }
    }
    container {
        user = "crm"
        mainClass = "nl.codeclan.CrmBackendApplicationKt"
    }
}