package com.sinaseyfi.kiliaroalbum.data.album.repository

import com.sinaseyfi.kiliaroalbum.data.album.api.AlbumApiService
import com.sinaseyfi.kiliaroalbum.data.album.database.AlbumTableMapper
import com.sinaseyfi.kiliaroalbum.data.album.model.AlbumModel
import com.sinaseyfi.kiliaroalbum.data.base.database.Database
import com.sinaseyfi.kiliaroalbum.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.lang.Exception
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val albumApiService: AlbumApiService,
    private val database: Database,
    private val albumTableMapper: AlbumTableMapper
): AlbumRepository {

    override suspend fun getListMediaInSharedItem(): Flow<Resource<List<AlbumModel>>> {
        val apiData = albumApiService.getListMediaInSharedItem().data
        database.database.getAlbumDao().insertAll(
            List(apiData?.size ?: 0) { index -> albumTableMapper.mapToTable(apiData!![index]) }
        )
        return database.database.getAlbumDao().getAll().map {
                list -> Resource.success(List(list.size) { index -> albumTableMapper.mapToModel(list[index]) })
        }
    }

}