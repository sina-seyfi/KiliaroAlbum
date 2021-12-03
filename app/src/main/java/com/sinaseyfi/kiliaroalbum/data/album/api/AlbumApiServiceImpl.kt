package com.sinaseyfi.kiliaroalbum.data.album.api

import com.sinaseyfi.kiliaroalbum.BuildConfig
import com.sinaseyfi.kiliaroalbum.data.album.model.AlbumModel
import com.sinaseyfi.kiliaroalbum.data.base.api.BaseApiService
import com.sinaseyfi.kiliaroalbum.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AlbumApiServiceImpl @Inject constructor()
    : BaseApiService<AlbumEndpoint>(AlbumEndpoint::class.java), AlbumApiService {

    override fun getListMediaInSharedItemFlow(): Flow<Resource<List<AlbumModel>>> = flow {
        emit(Resource.loading())
        emit(execute { apiService.getListMediaInSharedItem(BuildConfig.SHARE_ID) })
    }

}