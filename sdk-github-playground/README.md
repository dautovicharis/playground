# SDK GitHub Playground

A simple project demonstrating how to create and publish an Android SDK to a GitHub-hosted Maven repository.

## Project Structure

This project consists of two main modules:

- **sdk**: The SDK library that can be published and used by other applications
- **app**: A sample Android application that demonstrates how to use the SDK

## Using the SDK in Your Project

To use this SDK in your own project, add the following to your project's `settings.gradle.kts` file:

```kotlin
dependencyResolutionManagement {
    repositories {
        // Other repositories (Google, MavenCentral, etc.)

        // Add the GitHub repository
        maven {
            name = "GitHubSDKReleases"
            url = uri("https://github.com/dautovicharis/playground/raw/main/sdk-github-playground/sdk/releases")
        }
    }
}
```

Then add the dependency to your module's `build.gradle.kts` file:

```kotlin
dependencies {
    implementation("com.harisdautovic:github-playground-sdk:0.0.2")
}
```

## SDK Features

The SDK currently provides a simple method:

```kotlin
// Create an instance of the SDK
val sdk = GithubPlaygroundSdk()

// Use the SDK
val message = sdk.helloFromSdk() // Returns "Hello from SDK"
```

## Releasing a New Version

To release a new version of the SDK:

1. Update the version number in `sdk/build.gradle.kts`:

```kotlin
group = "com.harisdautovic"
version = "0.0.2" // Change this to the new version
val artifactId = "github-playground-sdk"
```

The publication block will automatically use this version.

2. Run the release script:

```bash
./release-sdk.sh
```

3. Commit and push the changes, including the new files in the `sdk/releases` directory:

```bash
git add .
git commit -m "Release version X.Y.Z"
git push
```
