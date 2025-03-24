import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    id("org.jlleitschuh.gradle.ktlint") version "11.5.0"
}

group = "com.ForumApi"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17 // Atualizado para Java 17

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.jsonwebtoken:jjwt:0.9.1")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17" // Atualizado para Java 17
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

ktlint {
    version.set("0.48.2") // Mantido atualizado
    android.set(false)
    outputToConsole.set(true)
    coloredOutput.set(true) // Mantido atualizado
    ignoreFailures.set(false)
}
