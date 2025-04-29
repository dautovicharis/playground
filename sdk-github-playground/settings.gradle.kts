pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            name = "GitHubSDKReleases"
            url = uri("https://github.com/dautovicharis/playground/raw/main/sdk-github-playground/sdk/releases")
        }
    }
}

rootProject.name = "sdk-github-playground"
include(":app")
//include(":sdk")
