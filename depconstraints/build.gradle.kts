plugins {
    id("java-platform")
    id("maven-publish")
}

val core = "1.7.0"
val compose = Versions.COMPOSE
val navigationCompose = "2.4.2"
val navigationTest = "2.4.2"
val lifecycle = "2.4.1"
val fragment = "1.4.1"
val appcompat = "1.4.1"
val hilt = Versions.HILT_AGP
val hiltNavigationCompose = "1.0.0"
val room = "2.4.2"
val retrofit = "2.9.0"
val okhttp = "4.9.2"
val coroutines = "1.6.1"
val glide = "4.13.0"
val coilCompose = "2.0.0-rc03"
val timber = "4.7.1"
val coreTest = "1.4.0"
val junit = "4.13.2"
val archTest = "2.1.0"
val extJunit = "1.1.3"
val espresso = "3.4.0"

dependencies {
    constraints {
        api("${Libs.CORE_KTX}:$core")
        api("${Libs.COMPOSE_UI}:$compose")
        api("${Libs.COMPOSE_MATERIAL}:$compose")
        api("${Libs.COMPOSE_UI_PREVIEW}:$compose")
        api("${Libs.COMPOSE_MATERIAL}:$compose")
        api("${Libs.COMPOSE_ACTIVITY}:$compose")
        api("${Libs.NAVIGATION_COMPOSE}:$navigationCompose")
        api("${Libs.LIFECYCLE_RUNTIME_KTX}:$lifecycle")
        api("${Libs.LIFECYCLE_VIEWMODEL_KTX}:$lifecycle")
        api("${Libs.LIFECYCLE_LIVEDATA_KTX}:$lifecycle")
        api("${Libs.LIFECYCLE_VIEWMODEL_COMPOSE}:$lifecycle")
        api("${Libs.FRAGMENT_KTX}:$fragment")
        api("${Libs.APPCOMPAT}:$appcompat")
        api("${Libs.HILT_ANDROID}:$hilt")
        api("${Libs.HILT_COMPILER}:$hilt")
        api("${Libs.HILT_NAVIGATION_COMPOSE}:$hiltNavigationCompose")
        api("${Libs.ROOM_KTX}:$room")
        api("${Libs.ROOM_RUNTIME}:$room")
        api("${Libs.ROOM_COMPILER}:$room")
        api("${Libs.RETROFIT}:$retrofit")
        api("${Libs.RETROFIT_CONVERTER_GSON}:$retrofit")
        api("${Libs.OKHTTP_LOGGING_INTERCEPTOR}:$okhttp")
        api("${Libs.COROUTINES_ANDROID}:$coroutines")
        api("${Libs.COROUTINES_TEST}:$coroutines")
        api("${Libs.GLIDE}:$glide")
        api("${Libs.COIL_COMPOSE}:$coilCompose")
        api("${Libs.TIMBER}:$timber")
        api("${Libs.CORE_KTX_TEST}:$coreTest")
        api("${Libs.JUNIT}:$junit")
        api("${Libs.ARCH_TEST}:$archTest")
        api("${Libs.EXT_JUNIT_KTX}:$extJunit")
        api("${Libs.ESPRESSO_CORE}:$espresso")
        api("${Libs.NAVIGATION_TEST}:$navigationTest")
        api("${Libs.HILT_TEST}:$hilt")
        api("${Libs.COMPOSE_TEST}:$compose")
        api("${Libs.COMPOSE_TOOLING}:$compose")
        api("${Libs.COMPOSE_TEST_MANIFEST}:$compose")
    }
}

publishing {
    publications {
        create<MavenPublication>("myPlatform") {
            from(components["javaPlatform"])
        }
    }
}

