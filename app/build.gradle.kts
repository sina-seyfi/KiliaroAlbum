plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Configuration.compileSdkVersion
    buildToolsVersion = Configuration.buildToolsVersion
    defaultConfig {
        applicationId = "com.sinaseyfi.${Configuration.projectName}"
        minSdk = Configuration.minSdkVersion
        targetSdk = Configuration.targetSdkVersion
        versionCode = Configuration.versionCode
        versionName = Configuration.versionName
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            this.isMinifyEnabled = false
            this.isShrinkResources = false
            this.isDebuggable = true
        }
        getByName("release") {
            this.isMinifyEnabled = true
            this.isShrinkResources = true
            this.isDebuggable = false
            this.proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        this.viewBinding = true
    }

    compileOptions {
        sourceCompatibility = Configuration.JavaVersionSupport
        targetCompatibility = Configuration.JavaVersionSupport
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    kapt {
        correctErrorTypes = true
    }

    flavorDimensions.apply {
        add("base")
    }

    productFlavors {
        this.register("develop") {
            manifestPlaceholders.putAll(mapOf("app_name" to "${Configuration.appName} - develop"))
            dimension = "base"
            this.applicationIdSuffix = "dev"
            listOf(
                Triple("String", "API_BASE_URL", "https://api1.kiliaro.com/"),
                Triple("String", "SHARE_ID", "djlCbGusTJamg_ca4axEVw"),
                Triple("int", "DATABASE_VERSION", "1"),
                Triple("String", "SCHEMA_NAME", "kiliaro_db")
            ).forEach {
                this.buildConfigField(it.first, it.second, if(it.first == "String") "\"${it.third}\"" else it.third)
            }
        }
    }

    variantFilter {
        this.flavors.forEach {
            val flavorName = it.name
            val buildType = this.buildType.name
            if(flavorName == "develop" && buildType == "release")
                ignore = true
        }
    }

}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = Configuration.jvmTarget
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    CoreDependencies.dependencyNotation.forEach {
        this.add(it.first, it.second)
    }
}