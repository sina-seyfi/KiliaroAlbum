package com.sinaseyfi.kiliaroalbum.data.album.api

import com.sinaseyfi.kiliaroalbum.data.album.model.AlbumModel
import com.sinaseyfi.kiliaroalbum.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AlbumApiService {

    fun getListMediaInSharedItemFlow(): Flow<Resource<List<AlbumModel>>>

}