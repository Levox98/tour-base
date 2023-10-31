plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = Config.packageName
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.compilerVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(platform(Dependencies.Compose.bom))

    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.Lifecycle.lifecycleRuntime)
    implementation(Dependencies.Lifecycle.activityCompose)
    implementation(Dependencies.Lifecycle.activity)

    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.material3)

    kapt(Dependencies.Hilt.kapt)
    implementation(Dependencies.Hilt.hilt)

    implementation(Dependencies.Navigation.navigation)
}