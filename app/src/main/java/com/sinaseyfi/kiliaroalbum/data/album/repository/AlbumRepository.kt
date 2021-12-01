package com.sinaseyfi.kiliaroalbum.data.album.repository

import com.sinaseyfi.kiliaroalbum.data.album.model.AlbumModel
import com.sinaseyfi.kiliaroalbum.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {

    suspend fun getListMediaInSharedItem(): Flow<Resource<List<AlbumModel>>>

}