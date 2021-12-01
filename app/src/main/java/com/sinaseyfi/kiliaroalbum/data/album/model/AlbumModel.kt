package com.sinaseyfi.kiliaroalbum.data.album.model

import com.google.gson.annotations.SerializedName
import com.sinaseyfi.kiliaroalbum.data.base.Model
import com.sinaseyfi.kiliaroalbum.data.base.api.CONTENT_TYPE
import com.sinaseyfi.kiliaroalbum.data.base.api.CREATED_AT
import com.sinaseyfi.kiliaroalbum.data.base.api.DOWNLOAD_URL
import com.sinaseyfi.kiliaroalbum.data.base.api.FILE_NAME
import com.sinaseyfi.kiliaroalbum.data.base.api.GUESSED_TAKEN_AT
import com.sinaseyfi.kiliaroalbum.data.base.api.ID
import com.sinaseyfi.kiliaroalbum.data.base.api.MD5SUM
import com.sinaseyfi.kiliaroalbum.data.base.api.MEDIA_TYPE
import com.sinaseyfi.kiliaroalbum.data.base.api.RESX
import com.sinaseyfi.kiliaroalbum.data.base.api.RESY
import com.sinaseyfi.kiliaroalbum.data.base.api.SIZE
import com.sinaseyfi.kiliaroalbum.data.base.api.TAKEN_AT
import com.sinaseyfi.kiliaroalbum.data.base.api.THUMBNAIL_URL
import com.sinaseyfi.kiliaroalbum.data.base.api.USER_ID
import com.sinaseyfi.kiliaroalbum.data.base.api.VIDEO

data class AlbumModel(
    @SerializedName(ID)
    val id: String,
    @SerializedName(USER_ID)
    val userId: String,
    @SerializedName(MEDIA_TYPE)
    val mediaType: String,
    @SerializedName(FILE_NAME)
    val fileName: String,
    @SerializedName(SIZE)
    val size: Int,
    @SerializedName(CREATED_AT)
    val createdAt: String,
    @SerializedName(TAKEN_AT)
    val takenAt: String?,
    @SerializedName(GUESSED_TAKEN_AT)
    val guessedTakenAt: String?,
    @SerializedName(MD5SUM)
    val md5sum: String,
    @SerializedName(CONTENT_TYPE)
    val contentType: String,
    @SerializedName(VIDEO)
    val video: String?,
    @SerializedName(THUMBNAIL_URL)
    val thumbnailUrl: String,
    @SerializedName(DOWNLOAD_URL)
    val downloadUrl: String,
    @SerializedName(RESX)
    val resx: Int,
    @SerializedName(RESY)
    val resy: Int
): Model