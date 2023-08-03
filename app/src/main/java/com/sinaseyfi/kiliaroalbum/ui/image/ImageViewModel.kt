package com.sinaseyfi.kiliaroalbum.ui.image

import com.sinaseyfi.kiliaroalbum.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(): BaseViewModel<ImageState>(ImageState.ImageLoading) {

    fun setImageIsLoading() {
        setViewState(ImageState.ImageLoading)
    }

    fun setImageFailedToLoad() {
        setViewState(ImageState.ImageError)
    }

    fun setImageLoaded() {
        setViewState(ImageState.ImageLoaded)
    }

}