pluginManagement {
    repositories {
        google()
        maven( url = "https://jitpack.io")
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven( url = "https://jitpack.io")
        google()
        mavenCentral()
    }
}

rootProject.name = "LibaryappDemo"
include(":app")
 