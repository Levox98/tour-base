plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "ru.tour_base.core_navigation"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Config.sourceCompatibility
        targetCompatibility = Config.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {

    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.Kotlin.collections)

    implementation(platform(Dependencies.Compose.bom))
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.material3)
    implementation(Dependencies.Compose.iconsExtended)

    implementation(Dependencies.Lifecycle.lifecycleViewmodel)

    implementation(Dependencies.Navigation.navigation)
    implementation(Dependencies.Navigation.hilt)
}