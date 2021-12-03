package com.sinaseyfi.kiliaroalbum.data.album.database

import com.sinaseyfi.kiliaroalbum.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AlbumLocalSource {

    fun getAllAlbumTable(): Flow<Resource<List<AlbumTable>>>
    suspend fun insertAllAlbumTable(list: List<AlbumTable>)
    suspend fun clearAlbumTable()

}