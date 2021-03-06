package com.sinaseyfi.kiliaroalbum.data.base.database

import android.content.Context
import androidx.room.Room
import com.sinaseyfi.kiliaroalbum.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Database @Inject constructor(
    @ApplicationContext private val context: Context
) {

    val database: AppDatabase by lazy {
        Room.databaseBuilder(context, AppDatabase::class.java, BuildConfig.SCHEMA_NAME).fallbackToDestructiveMigration().build()
    }

}