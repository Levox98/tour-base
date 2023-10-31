pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:8.1.0")
            }
            if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
                useVersion("1.9.10")
            }
            if (requested.id.id.startsWith("dagger.hilt.android")) {
                useModule("com.google.dagger:hilt-android-gradle-plugin:2.48.1")
            }
        }
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
include(":core-navigation")
