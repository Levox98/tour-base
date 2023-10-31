pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Tour base(test task)"
include(":app")
include(":core-network")
include(":core-ui")
include(":data-main")
include(":feature-main")
include(":feature-blog")
include(":core")
