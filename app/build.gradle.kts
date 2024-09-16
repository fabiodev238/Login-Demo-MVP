plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.devs.loginmvp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.devs.loginmvp"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


    dependencies {

       // val daggerVersion = "2.9"
       // implementation ("javax.annotation:javax.annotation-api:1.3.2")

        implementation(libs.appcompat)
        implementation(libs.material)
        implementation(libs.activity)
        implementation(libs.constraintlayout)

        testImplementation ("org.mockito:mockito-core:2.19.0")
        testImplementation(libs.junit)
        androidTestImplementation(libs.ext.junit)
        androidTestImplementation(libs.espresso.core)

        //Dagger II
        implementation("com.google.dagger:dagger:2.48")
        annotationProcessor("com.google.dagger:dagger-compiler:2.48")

    }
}