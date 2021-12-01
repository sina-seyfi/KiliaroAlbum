package com.sinaseyfi.kiliaroalbum.data.album.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sinaseyfi.kiliaroalbum.data.base.Table
import com.sinaseyfi.kiliaroalbum.data.base.database.CONTENT_TYPE
import com.sinaseyfi.kiliaroalbum.data.base.database.CREATED_AT
import com.sinaseyfi.kiliaroalbum.data.base.database.DOWNLOAD_URL
import com.sinaseyfi.kiliaroalbum.data.base.database.FILE_NAME
import com.sinaseyfi.kiliaroalbum.data.base.database.GUESSED_TAKEN_AT
import com.sinaseyfi.kiliaroalbum.data.base.database.ID
import com.sinaseyfi.kiliaroalbum.data.base.database.MD5SUM
import com.sinaseyfi.kiliaroalbum.data.base.database.MEDIA_TYPE
import com.sinaseyfi.kiliaroalbum.data.base.database.RESX
import com.sinaseyfi.kiliaroalbum.data.base.database.RESY
import com.sinaseyfi.kiliaroalbum.data.base.database.SIZE
import com.sinaseyfi.kiliaroalbum.data.base.database.TAKEN_AT
import com.sinaseyfi.kiliaroalbum.data.base.database.THUMBNAIL_URL
import com.sinaseyfi.kiliaroalbum.data.base.database.USER_ID
import com.sinaseyfi.kiliaroalbum.data.base.database.VIDEO

@Entity(tableName = "album")
data class AlbumTable(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id: String,
    @ColumnInfo(name = USER_ID)
    val userId: String,
    @ColumnInfo(name = MEDIA_TYPE)
    val mediaType: String,
    @ColumnInfo(name = FILE_NAME)
    val fileName: String,
    @ColumnInfo(name = SIZE)
    val size: Int,
    @ColumnInfo(name = CREATED_AT)
    val createdAt: String,
    @ColumnInfo(name = TAKEN_AT)
    val takenAt: String?,
    @ColumnInfo(name = GUESSED_TAKEN_AT)
    val guessedTakenAt: String?,
    @ColumnInfo(name = MD5SUM)
    val md5sum: String,
    @ColumnInfo(name = CONTENT_TYPE)
    val contentType: String,
    @ColumnInfo(name = VIDEO)
    val video: String?,
    @ColumnInfo(name = THUMBNAIL_URL)
    val thumbnailUrl: String,
    @ColumnInfo(name = DOWNLOAD_URL)
    val downloadUrl: String,
    @ColumnInfo(name = RESX)
    val resx: Int,
    @ColumnInfo(name = RESY)
    val resy: Int
): Table