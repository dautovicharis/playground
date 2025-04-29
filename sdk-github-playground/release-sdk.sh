#!/bin/bash

# Simple script to release the SDK to the local Maven repository

# Clean and build the SDK
./gradlew :sdk:clean :sdk:build

# Publish the SDK to the local Maven repository
./gradlew :sdk:publishSdkPublicationToLocalReleasesRepository

echo "SDK published to sdk/releases"
