plugins {
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.graalvm.native)
	//
	alias(libs.plugins.kotlin.spring)
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.spring.dependency.management)
}

group = "com.ntt"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = libs.versions.spring.cloud.get()

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server")
//	- MONITORING
	implementation("org.springframework.boot:spring-boot-starter-actuator")
//	- DEVELOPMENT
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	// NTT - NO-need developmentOnly("org.springframework.boot:spring-boot-docker-compose")
	// NTT - NO-need annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
//	- TESTING
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
