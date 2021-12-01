package com.sinaseyfi.kiliaroalbum.data.album.api

import com.sinaseyfi.kiliaroalbum.data.album.model.AlbumModel
import com.sinaseyfi.kiliaroalbum.data.base.api.SHARED_KEY
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumEndpoint {

    @GET("shared/{$SHARED_KEY}/media")
    suspend fun getListMediaInSharedItem(@Path(SHARED_KEY) sharedKey: String): List<AlbumModel>

}