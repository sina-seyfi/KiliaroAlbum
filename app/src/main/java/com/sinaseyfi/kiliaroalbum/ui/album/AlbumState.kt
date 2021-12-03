package com.sinaseyfi.kiliaroalbum.ui.album

import com.sinaseyfi.kiliaroalbum.ui.base.ViewState

class AlbumState(
    override val isLoading: Boolean = false,
    val failedToSync: Boolean = false
) : ViewState