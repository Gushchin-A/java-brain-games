plugins {
    application
    id("com.github.ben-manes.versions") version "0.52.0"
    checkstyle
    id("org.sonarqube") version "6.2.0.5505"
}

application {
    mainClass = "hexlet.code.App"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

sonar {
  properties {
    property("sonar.projectKey", "Gushchin-A_java-project-61")
    property("sonar.organization", "gushchin-a")
    property("sonar.host.url", "https://sonarcloud.io")
  }
}

