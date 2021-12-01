// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    val kotlinVersion by extra(Configuration.kotlinVersion)
    repositories {
        flatDir { this.dir("libs") }
        google()
        jcenter()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Configuration.gradleVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Configuration.kotlinVersion}")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:${AppVersions.navigationVersion}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${AppVersions.hiltVersion}")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts.kts files
    }

}


tasks.register("clean").configure {
    delete("build")
}