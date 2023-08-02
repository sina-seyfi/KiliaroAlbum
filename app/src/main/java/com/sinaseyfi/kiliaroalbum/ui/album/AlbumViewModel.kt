package com.sinaseyfi.kiliaroalbum.ui.album

import com.sinaseyfi.kiliaroalbum.data.album.repository.AlbumRepository
import com.sinaseyfi.kiliaroalbum.data.base.ConnectionException
import com.sinaseyfi.kiliaroalbum.ui.album.model.AlbumModelMapper
import com.sinaseyfi.kiliaroalbum.ui.base.BaseViewModel
import com.sinaseyfi.kiliaroalbum.utils.Status
import com.sinaseyfi.kiliaroalbum.utils.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val albumRepository: AlbumRepository,
    private val albumModelMapper: AlbumModelMapper
): BaseViewModel<AlbumState>(AlbumState.AlbumLoading) {

    fun fetchAlbums() {
        launch {
            albumRepository.getListMediaInSharedItem().collect {
                when(it.status) {
                    Status.ERROR -> {
                        setViewState(AlbumState.AlbumError(failedToSync = it.error is ConnectionException))
                    }
                    Status.SUCCESS -> {
                        setViewState(
                            AlbumState.AlbumSuccessfullyLoaded(
                                it.data?.map { model -> albumModelMapper.mapToUIModel(model) } ?: emptyList()
                            )
                        )
                    }
                    Status.LOADING -> {
                        setViewState(AlbumState.AlbumLoading)
                    }
                }
            }
        }
    }

}