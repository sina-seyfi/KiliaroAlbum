package com.sinaseyfi.kiliaroalbum

import android.app.Application
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

}