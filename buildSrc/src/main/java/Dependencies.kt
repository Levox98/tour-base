object Dependencies {

    object Kotlin {
        const val version = "1.9.10"
        private const val coroutinesVersion = "1.7.0"
        private const val collectionsVersion = "0.3.5"

        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
        const val collections = "org.jetbrains.kotlinx:kotlinx-collections-immutable:$collectionsVersion"
    }

    object Compose {
        private const val bomVersion = "2023.09.02"
        const val compilerVersion = "1.5.3"

        const val bom = "androidx.compose:compose-bom:$bomVersion"
        const val ui = "androidx.compose.ui:ui"
        const val runtime = "androidx.compose.runtime:runtime"
        const val material3 = "androidx.compose.material3:material3"
        const val iconsExtended = "androidx.compose.material:material-icons-extended"
        const val foundation = "androidx.compose.foundation:foundation"
    }

    object Hilt {
        private const val version = "2.48.1"
        private const val navigationVersion = "1.0.0"

        const val hilt = "com.google.dagger:hilt-android:$version"
        const val kapt = "com.google.dagger:hilt-android-compiler:$version"
        const val navigation = "androidx.hilt:hilt-navigation-compose:$navigationVersion"
    }

    object Retrofit {
        private const val version = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val okhttpBomVersion = "4.10.0"

        const val bom = "com.squareup.okhttp3:okhttp-bom:$okhttpBomVersion"

        val okHttp = "com.squareup.okhttp3:okhttp"
        val interceptor = "com.squareup.okhttp3:logging-interceptor"
    }

    object Picasso {
        private const val version = "2.8"

        const val picasso = "com.squareup.picasso:picasso:$version"
    }

    object Lifecycle {
        private const val lifecycleVersion = "2.4.1"
        private const val composeViewModelVersion = "2.4.0-rc01"
        private const val activityComposeVersion = "1.7.0"
        private const val activityVersion = "1.8.0-beta01"

        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
        const val lifecycleViewmodel = "androidx.lifecycle:lifecycle-viewmodel-compose:$composeViewModelVersion"
        const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
        val activity = "androidx.activity:activity-ktx:$activityVersion"
    }

    object Room {
        private const val version = "2.6.0-rc01"

        const val api = "androidx.room:room-runtime:$version"
        const val kapt = "androidx.room:room-compiler:$version"
        const val room = "androidx.room:room-ktx:$version"
    }

    object Navigation {
        private const val navigationVersion = "2.4.2"
        private const val hiltNavVersion = "1.0.0"

        const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"
        const val hilt = "androidx.hilt:hilt-navigation-compose:$hiltNavVersion"
    }

    object AndroidX {
        private const val coreVersion = "1.10.0"
        private const val appCompatVersion = "1.6.1"
        private const val activityComposeVersion = "1.7.1"
        private const val lifecycleViewmodelVersion = "2.6.1"

        const val core = "androidx.core:core-ktx:$coreVersion"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
        const val appCompatResources = "androidx.appcompat:appcompat-resources:$appCompatVersion"
        const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
        const val lifecycleViewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleViewmodelVersion"
    }
}