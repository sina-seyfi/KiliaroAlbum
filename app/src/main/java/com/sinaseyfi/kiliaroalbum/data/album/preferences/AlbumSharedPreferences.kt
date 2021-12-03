package com.sinaseyfi.kiliaroalbum.data.album.preferences

import android.content.Context
import com.sinaseyfi.kiliaroalbum.data.base.sharedpreferences.BaseSharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AlbumSharedPreferences @Inject constructor(
    @ApplicationContext context: Context
): BaseSharedPreferences(context) {

    companion object {
        private const val ALBUM_LIST_TIMESTAMP_LABEL = "album_list_timestamp_label"
    }

    fun lastUpdatedDb(): Long =
        sharedPreferences.getLong(ALBUM_LIST_TIMESTAMP_LABEL, 0L)

    fun dbUpdatedOn(timestamp: Long) {
        sharedPreferences.edit().putLong(ALBUM_LIST_TIMESTAMP_LABEL, timestamp).apply()
    }

}