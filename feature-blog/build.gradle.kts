plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "ru.tour_base.feature_blog"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.compilerVersion
    }
}

dependencies {

    implementation(project(":core"))
    implementation(project(":core-navigation"))
    implementation(project(":core-network"))
    implementation(project(":core-ui"))
    implementation(project(":data-main"))

    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.Kotlin.collections)

    kapt(Dependencies.Hilt.kapt)
    implementation(Dependencies.Hilt.hilt)

    implementation(platform(Dependencies.Compose.bom))
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.material3)
    implementation(Dependencies.Compose.iconsExtended)

    implementation(Dependencies.Lifecycle.lifecycleViewmodel)

    implementation(Dependencies.Navigation.navigation)
    implementation(Dependencies.Navigation.hilt)

    implementation(Dependencies.Picasso.picasso)
    implementation(Dependencies.Util.markdown)
}