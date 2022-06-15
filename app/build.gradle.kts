plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        applicationId = "com.younny.demo.thecatapp"
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        testInstrumentationRunner = "com.younny.demo.thecatapp.CustomTestRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    api(platform(project(":depconstraints")))
    kapt(platform(project(":depconstraints")))
    androidTestApi(platform(project(":depconstraints")))

    implementation(Libs.CORE_KTX)

    implementation(Libs.FRAGMENT_KTX)
    implementation(Libs.APPCOMPAT)

    implementation(Libs.COMPOSE_UI)
    implementation(Libs.COMPOSE_MATERIAL)
    implementation(Libs.COMPOSE_UI_PREVIEW)
    implementation(Libs.COMPOSE_ACTIVITY)
    implementation(Libs.NAVIGATION_COMPOSE)

    implementation(Libs.LIFECYCLE_RUNTIME_KTX)
    implementation(Libs.LIFECYCLE_VIEWMODEL_KTX)
    implementation(Libs.LIFECYCLE_LIVEDATA_KTX)
    implementation(Libs.LIFECYCLE_VIEWMODEL_COMPOSE)

    /* Dependency Injection */
    implementation(Libs.HILT_ANDROID)
    kapt(Libs.HILT_COMPILER)
    implementation(Libs.HILT_NAVIGATION_COMPOSE)

    /* Database */
    implementation(Libs.ROOM_KTX)
    implementation(Libs.ROOM_RUNTIME)
    kapt(Libs.ROOM_COMPILER)

    /* Networking */
    implementation(Libs.RETROFIT)
    implementation(Libs.RETROFIT_CONVERTER_GSON)
    implementation(Libs.OKHTTP_LOGGING_INTERCEPTOR)

    /* Coroutine */
    implementation(Libs.COROUTINES_ANDROID)

    /* Image Caching */
    implementation(Libs.GLIDE)
    implementation(Libs.COIL_COMPOSE)

    /* Log */
    implementation(Libs.TIMBER)

    /* Test */
    testImplementation(Libs.COROUTINES_TEST)
    testImplementation(Libs.CORE_KTX)
    testImplementation(Libs.JUNIT)
    testImplementation(Libs.CORE_KTX_TEST)
    androidTestImplementation(Libs.ARCH_TEST)
    androidTestImplementation(Libs.EXT_JUNIT_KTX)
    androidTestImplementation(Libs.ESPRESSO_CORE)
    androidTestImplementation(Libs.NAVIGATION_TEST)
    androidTestImplementation(Libs.HILT_TEST)
    kaptAndroidTest(Libs.HILT_COMPILER)
    androidTestImplementation(Libs.COMPOSE_TEST)
    debugImplementation(Libs.COMPOSE_TOOLING)
    debugImplementation(Libs.COMPOSE_TEST_MANIFEST)

}