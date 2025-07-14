plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.flawless"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.flawless"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        viewBinding = false
    }
}

dependencies {
    // Compose & ViewModel
    implementation("com.google.android.gms:play-services-auth:21.2.0")

    implementation("io.supabase.kt:gotrue-kt:2.4.1")      // Untuk auth jika diperlukan
    implementation("io.supabase.kt:postgrest-kt:2.4.1")   // Untuk database jika diperlukan
    implementation("io.supabase.kt:storage-kt:2.4.1")     // untuk upload gambar

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")

    implementation("io.ktor:ktor-client-android:2.3.11")
    implementation("androidx.credentials:credentials:1.3.0")
    implementation("androidx.credentials:credentials-play-services-auth:1.3.0")
    implementation("com.google.android.libraries.identity.googleid:googleid:1.1.1")
    implementation("com.google.firebase:firebase-auth")
    implementation(libs.androidx.material.icons.extended)
    implementation("androidx.compose.ui:ui:...")
    implementation("io.coil-kt:coil-compose:2.6.0")
    implementation(platform("com.google.firebase:firebase-bom:33.16.0"))
    implementation("com.google.firebase:firebase-auth-ktx")
    // Firebase Cloud Firestore
    implementation("com.google.firebase:firebase-firestore-ktx")
    // Firebase Cloud Storage
    implementation("com.google.firebase:firebase-storage-ktx")
    // Glide (untuk memuat gambar dari URL Firebase Storage)
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation(libs.androidx.media3.effect)
    implementation(libs.androidx.navigation.compose)
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.storage)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}