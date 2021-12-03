package com.sinaseyfi.kiliaroalbum.data.album.validator

import android.text.format.DateUtils
import com.sinaseyfi.kiliaroalbum.data.album.database.AlbumTable
import com.sinaseyfi.kiliaroalbum.data.album.preferences.AlbumSharedPreferences
import com.sinaseyfi.kiliaroalbum.data.base.SourceValidator
import com.sinaseyfi.kiliaroalbum.utils.nowTimestamp
import timber.log.Timber
import javax.inject.Inject
import kotlin.math.abs

class AlbumSourceValidator @Inject constructor(
    private val albumSharedPreferences: AlbumSharedPreferences
): SourceValidator<List<AlbumTable>> {

    companion object {
        private const val UPDATE_OFFSET_VALID = 3600 * 1000L
    }

    override suspend fun isValid(): Boolean =
        abs((albumSharedPreferences.lastUpdatedDb() - DateUtils().nowTimestamp())) < UPDATE_OFFSET_VALID

    override suspend fun updated(source: List<AlbumTable>?) {
        albumSharedPreferences.dbUpdatedOn(DateUtils().nowTimestamp())
    }

}