package com.sinaseyfi.kiliaroalbum.ui.album.model

import com.sinaseyfi.kiliaroalbum.ui.base.RecyclerItemModel
import java.io.Serializable

data class Album(
    val id: String,
    val size: Int,
    val createdAt: String,
    val thumbnailUrl: String,
    val downloadUrl: String
): RecyclerItemModel<String>, Serializable { override fun provideId(): String = id }