package com.sinaseyfi.kiliaroalbum

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import dagger.hilt.android.HiltAndroidApp
import net.time4j.android.ApplicationStarter
import timber.log.Timber

@HiltAndroidApp
class KiliaroApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        ApplicationStarter.initialize(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}