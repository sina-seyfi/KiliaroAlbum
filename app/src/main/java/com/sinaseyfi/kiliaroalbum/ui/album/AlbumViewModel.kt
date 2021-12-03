package com.sinaseyfi.kiliaroalbum.ui.album

import androidx.lifecycle.viewModelScope
import com.sinaseyfi.kiliaroalbum.data.album.model.AlbumModel
import com.sinaseyfi.kiliaroalbum.data.album.repository.AlbumRepository
import com.sinaseyfi.kiliaroalbum.data.base.ConnectionException
import com.sinaseyfi.kiliaroalbum.ui.album.model.Album
import com.sinaseyfi.kiliaroalbum.ui.album.model.AlbumModelMapper
import com.sinaseyfi.kiliaroalbum.ui.base.BaseViewModel
import com.sinaseyfi.kiliaroalbum.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val albumRepository: AlbumRepository,
    private val albumModelMapper: AlbumModelMapper
): BaseViewModel<AlbumState>(AlbumState()) {

    private val _albums = MutableStateFlow<List<Album>>(emptyList())
    val albums: StateFlow<List<Album>> = _albums

    fun fetchAlbums() {
        viewModelScope.launch {
            albumRepository.getListMediaInSharedItem().collect {
                _albums.value =
                    it.data?.map { model -> albumModelMapper.mapToUIModel(model) } ?: emptyList()
                _viewState.value = AlbumState(
                    isLoading = it.status == Status.LOADING,
                    failedToSync = it.status == Status.ERROR && it.error is ConnectionException
                )
            }
        }
    }

}