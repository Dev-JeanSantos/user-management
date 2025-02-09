plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	kotlin("plugin.jpa") version "1.9.25"
	id("org.springframework.boot") version "3.4.2"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.jetbrains.kotlin.kapt") version "1.9.25" // Adicionado plugin para kapt
}

group = "com.fourtkacademy"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// Banco de dados
	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")


	// SPRING VALIDATION
	implementation("org.springframework.boot:spring-boot-starter-validation:3.3.5")

	// MAPSTRUCT
	implementation("org.mapstruct:mapstruct:1.6.3") // Versão principal do MapStruct
	kapt("org.mapstruct:mapstruct-processor:1.6.3") // Processador de anotações

	//JPA
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	// https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
	testImplementation("ch.qos.logback:logback-classic:1.5.16")
	// https://mvnrepository.com/artifact/io.github.microutils/kotlin-logging
	implementation("io.github.microutils:kotlin-logging:4.0.0-beta-2")


	// Testes
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
	kotlinOptions {
		jvmTarget = "17"
		freeCompilerArgs += listOf("-Xjsr305=strict")
	}
}

tasks.withType<JavaCompile> {
	options.annotationProcessorGeneratedSourcesDirectory = file("build/generated/sources/annotationProcessor/java/main/")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
