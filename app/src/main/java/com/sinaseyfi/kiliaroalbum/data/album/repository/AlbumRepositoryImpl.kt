package com.sinaseyfi.kiliaroalbum.data.album.repository

import com.sinaseyfi.kiliaroalbum.data.album.api.AlbumApiService
import com.sinaseyfi.kiliaroalbum.data.album.database.AlbumLocalSource
import com.sinaseyfi.kiliaroalbum.data.album.database.AlbumTableMapper
import com.sinaseyfi.kiliaroalbum.data.album.model.AlbumModel
import com.sinaseyfi.kiliaroalbum.data.album.validator.AlbumSourceValidator
import com.sinaseyfi.kiliaroalbum.utils.Resource
import com.sinaseyfi.kiliaroalbum.utils.Status
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val albumApiService: AlbumApiService,
    private val albumLocalSource: AlbumLocalSource,
    private val albumTableMapper: AlbumTableMapper,
    private val albumSourceValidator: AlbumSourceValidator
): AlbumRepository {

    override fun getListMediaInSharedItem(): Flow<Resource<List<AlbumModel>>> = flow {
        if(!albumSourceValidator.isValid()) { albumLocalSource.clearAlbumTable() }
        val apiFlow = albumApiService.getListMediaInSharedItemFlow().onEach { apiData ->
            if(apiData.status == Status.SUCCESS) {
                val list = List(apiData.data?.size ?: 0) { index ->
                    albumTableMapper.mapToTable(apiData.data!![index])
                }
                albumLocalSource.insertAllAlbumTable(list)
                albumSourceValidator.updated(list)
            }
        }
        val localFlow = albumLocalSource.getAllAlbumTable()
        combine(apiFlow, localFlow) { apiData, localData ->
            val list = List(localData.data?.size ?: 0) { index ->
                albumTableMapper.mapToModel(localData.data!![index])
            }
            apiData.copy(data = list)
        }.collect { emit(it) }
    }

}