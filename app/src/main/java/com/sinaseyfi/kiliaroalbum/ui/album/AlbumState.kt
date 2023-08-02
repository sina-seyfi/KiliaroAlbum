package com.sinaseyfi.kiliaroalbum.ui.album

import com.sinaseyfi.kiliaroalbum.ui.album.model.Album
import com.sinaseyfi.kiliaroalbum.ui.base.ViewState

sealed class AlbumState: ViewState {
    object AlbumLoading: AlbumState()
    data class AlbumSuccessfullyLoaded(
        val albums: List<Album>
    ): AlbumState()
    data class AlbumError(val failedToSync: Boolean = false): AlbumState()

}