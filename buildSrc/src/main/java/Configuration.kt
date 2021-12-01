import org.gradle.api.JavaVersion

private object VersionConfiguration {
    const val versionMajor = 1
    const val versionMinor = 0
    const val versionPatch = 1
    const val buildNumber = 1
}

object Configuration {
    const val buildToolsVersion = "31.0.0"
    const val minSdkVersion = 26
    const val targetSdkVersion = 31
    const val compileSdkVersion = 31
    const val kotlinVersion = "1.5.31"
    const val gradleVersion = "7.0.3"
    const val versionCode = VersionConfiguration.buildNumber
    const val versionName =
        "${VersionConfiguration.versionMajor}.${VersionConfiguration.versionMinor}.${VersionConfiguration.versionPatch}"
    const val projectName = "kiliaroalbum"
    const val appName = "Kiliaro Album Sample"
    val JavaVersionSupport = JavaVersion.VERSION_1_8
    const val jvmTarget = "1.8"
}