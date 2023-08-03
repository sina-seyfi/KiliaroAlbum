object AppVersions {
    const val logInterceptorVersion = "4.9.1"
    const val timberVersion = "4.7.1"
    const val javaxInjectVersion = "1"
    const val retrofitVersion = "2.6.4"
    const val gsonVersion = "2.8.7"
    const val time4AVersion = "4.4.4-2019c"
    const val roomVersion = "2.3.0"
    const val okhttpVersion = "4.9.1"
    const val appCompatVersion = "1.3.0"
    const val coroutinesVersion = "1.5.0"
    const val glideVersion = "4.12.0"
    const val lifecycleVersion = "2.4.0"
    const val fragmentVersion = "1.4.0"
    const val activityVersion = "1.4.0"
    const val navigationVersion = "2.3.5"
    const val hiltVersion = "2.38.1"
    const val materialVersion = "1.5.0-alpha02"
    const val coreVersion = "1.7.0"
    const val constraintLayoutVersion = "2.0.4"
    const val lottieVersion = "3.5.0"
    const val imageWorkerVersion = "1.2.0"
    const val leakCanaryVersion = "2.7"
    const val hiltNavigationFragment = "1.0.0"
}


object CoreDependencies {

    const val core = "androidx.core:core-ktx:${AppVersions.coreVersion}"
    const val fragment =
        "androidx.fragment:fragment-ktx:${AppVersions.fragmentVersion}"
    const val material =
        "com.google.android.material:material:${AppVersions.materialVersion}"
    const val activity =
        "androidx.activity:activity-ktx:${AppVersions.activityVersion}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${AppVersions.lifecycleVersion}"

    const val kotlinConfig =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Configuration.kotlinVersion}"

    const val javaxInject = "javax.inject:javax.inject:${AppVersions.javaxInjectVersion}"

    const val navigationUi =
        "androidx.navigation:navigation-ui-ktx:${AppVersions.navigationVersion}"

    const val time4A = "net.time4j:time4j-android:${AppVersions.time4AVersion}"

    const val room = "androidx.room:room-runtime:${AppVersions.roomVersion}"

    const val retrofitGroupId = "com.squareup.retrofit2"

    const val retrofitConverter =
        "$retrofitGroupId:converter-gson:${AppVersions.retrofitVersion}"

    const val retrofit = "$retrofitGroupId:retrofit:${AppVersions.retrofitVersion}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${AppVersions.okhttpVersion}"

    const val gson =
        "com.google.code.gson:gson:${AppVersions.gsonVersion}"

    const val appCompat = "androidx.appcompat:appcompat:${AppVersions.appCompatVersion}"

    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${AppVersions.coroutinesVersion}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${AppVersions.hiltVersion}"

    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${AppVersions.hiltVersion}"

    const val glide = "com.github.bumptech.glide:glide:${AppVersions.glideVersion}"

    const val glideOkHttpIntegration = "com.github.bumptech.glide:okhttp3-integration:${AppVersions.glideVersion}"

    const val glideCompiler = "com.github.bumptech.glide:compiler:${AppVersions.glideVersion}"

    private const val logInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${AppVersions.logInterceptorVersion}"

    private const val timber = "com.jakewharton.timber:timber:${AppVersions.timberVersion}"

    private const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${AppVersions.constraintLayoutVersion}"

    private const val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${AppVersions.lifecycleVersion}"

    private const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${AppVersions.lifecycleVersion}"

    private const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${AppVersions.navigationVersion}"

    private const val hiltNavigationFragment =
        "androidx.hilt:hilt-navigation-fragment:${AppVersions.hiltNavigationFragment}"

    private const val lottie =
        "com.airbnb.android:lottie:${AppVersions.lottieVersion}"

    private const val leakCanary =
        "com.squareup.leakcanary:leakcanary-android:${AppVersions.leakCanaryVersion}"

    private const val roomKotlin = "androidx.room:room-ktx:${AppVersions.roomVersion}"

    private const val roomAnnotation = "androidx.room:room-compiler:${AppVersions.roomVersion}"



    val dependencyNotation = arrayOf(
        // Base Dependencies
        Pair("implementation", kotlinConfig),
        Pair("implementation", javaxInject),
        Pair("debugImplementation", leakCanary),
        Pair("implementation", coroutines),
        Pair("implementation", timber),
        Pair("implementation", time4A),
        // UI Dependencies
        Pair("implementation", core),
        Pair("implementation", appCompat),
        Pair("implementation", material),
        Pair("implementation", activity),
        Pair("implementation", fragment),
        Pair("implementation", navigationFragment),
        Pair("implementation", navigationUi),
        Pair("implementation", glide),
        Pair("kapt", glideCompiler),
        Pair("implementation", glideOkHttpIntegration),
        Pair("implementation", constraintLayout),
        Pair("implementation", lottie),
        // DI Dependencies
        Pair("implementation", hiltAndroid),
        Pair("kapt", hiltCompiler),
        Pair("implementation", hiltNavigationFragment),
        // Database Dependencies
        Pair("implementation", room),
        Pair("implementation", roomKotlin),
        Pair("kapt", roomAnnotation),
        // Lifecycle Dependencies
        Pair("implementation", lifecycleViewModel),
        Pair("implementation", lifecycleLiveData),
        Pair("implementation", lifecycleRuntime),
        // Remote Dependencies
        Pair("implementation", okHttp),
        Pair("implementation", retrofit),
        Pair("implementation", gson),
        Pair("implementation", retrofitConverter),
        Pair("developImplementation", logInterceptor),
    )

}