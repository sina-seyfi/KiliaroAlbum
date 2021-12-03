package com.sinaseyfi.kiliaroalbum.data.album.repository

import com.sinaseyfi.kiliaroalbum.data.album.api.AlbumApiService
import com.sinaseyfi.kiliaroalbum.data.album.database.AlbumLocalSource
import com.sinaseyfi.kiliaroalbum.data.album.database.AlbumTableMapper
import com.sinaseyfi.kiliaroalbum.data.album.model.AlbumModel
import com.sinaseyfi.kiliaroalbum.data.album.validator.AlbumSourceValidator
import com.sinaseyfi.kiliaroalbum.utils.Resource
import com.sinaseyfi.kiliaroalbum.utils.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val albumApiService: AlbumApiService,
    private val albumLocalSource: AlbumLocalSource,
    private val albumTableMapper: AlbumTableMapper,
    private val albumSourceValidator: AlbumSourceValidator
): AlbumRepository {

//    override suspend fun getListMediaInSharedItem(): Flow<Resource<List<AlbumModel>>> {
//        if(!albumSourceValidator.isValid()) { albumLocalSource.clearAlbumTable() }
//        val apiFlow = albumApiService.getListMediaInSharedItemFlow()
//        val localFlow = albumLocalSource.getAllAlbumTable()
//        apiFlow.collect { apiData ->
//            if(apiData.status == Status.SUCCESS) {
//                val list = List(apiData.data?.size ?: 0) { index ->
//                    albumTableMapper.mapToTable(apiData.data!![index])
//                }
//                albumLocalSource.insertAllAlbumTable(list)
//                albumSourceValidator.updated(list)
//            }
//        }
//        return combine(apiFlow, localFlow) { apiData, localData ->
//            if(localData.status == Status.ERROR) { apiData }
//            else {
//                val list = List(localData.data?.size ?: 0) { index ->
//                    albumTableMapper.mapToModel(localData.data!![index])
//                }
//                apiData.copy(data = list)
//            }
//        }
//    }

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

//    override suspend fun getListMediaInSharedItem(): Flow<Resource<List<AlbumModel>>> {
//        albumApiService.getListMediaInSharedItemFlow()
//        val apiData = albumApiService.getListMediaInSharedItem().data
//        database.database.getAlbumDao().insertAll(
//            List(apiData?.size ?: 0) { index -> albumTableMapper.mapToTable(apiData!![index]) }
//        )
//        return database.database.getAlbumDao().getAll().map {
//                list -> Resource.success(List(list.size) { index -> albumTableMapper.mapToModel(list[index]) })
//        }
//    }

}