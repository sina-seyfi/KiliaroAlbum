package com.sinaseyfi.kiliaroalbum.data.base.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sinaseyfi.kiliaroalbum.BuildConfig
import com.sinaseyfi.kiliaroalbum.data.album.database.AlbumDao
import com.sinaseyfi.kiliaroalbum.data.album.database.AlbumTable

@Database(
    version = BuildConfig.DATABASE_VERSION,
    entities = [AlbumTable::class],
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getAlbumDao(): AlbumDao

}