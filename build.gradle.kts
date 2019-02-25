plugins {
    java
    groovy

    id("org.asciidoctor.convert") version "1.5.9.2"
    id("org.springframework.boot") version "2.1.3.RELEASE"
}

apply {
    plugin("idea")
    plugin("eclipse")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
    plugin("org.asciidoctor.gradle.asciidoctor")
}

var asciidocSnippetsDir = file("build/generated-snippets")
tasks {
    test {
        outputs.dir(asciidocSnippetsDir)
    }

    asciidoctor {
        inputs.dir(asciidocSnippetsDir)
        dependsOn(test)
    }
}


group = "io.honeymon.boot.bpsboot"
version = "0.0.1-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    runtimeOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
}
