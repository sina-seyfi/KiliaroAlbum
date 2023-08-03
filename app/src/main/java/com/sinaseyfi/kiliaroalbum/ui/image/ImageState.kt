package com.sinaseyfi.kiliaroalbum.ui.image

import com.sinaseyfi.kiliaroalbum.ui.base.ViewState

sealed class ImageState: ViewState {
    object ImageLoading: ImageState()
    object ImageError: ImageState()
    object ImageLoaded: ImageState()
}