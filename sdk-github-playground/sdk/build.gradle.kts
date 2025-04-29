plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("maven-publish")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    withJavadocJar()
    withSourcesJar()
}

kotlin {
    jvmToolchain(11)
}

group = "com.harisdautovic"
version = "0.0.3"
val artifactId = "github-playground-sdk"

publishing {
    publications {
        create<MavenPublication>("sdk") {
            from(components["java"])

            // Use the project's group, artifactId and version
            groupId = project.group.toString()
            artifactId = artifactId
            version = project.version.toString()

            pom {
                name.set("GitHub Playground SDK")
                description.set("A simple SDK for testing GitHub releases")
            }
        }
    }

    repositories {
        maven {
            name = "LocalReleases"
            url = uri("${rootProject.projectDir}/sdk/releases")
        }
    }
}