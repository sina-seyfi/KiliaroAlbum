package com.sinaseyfi.kiliaroalbum.ui.base

// T: Unique ID of model to be compared when items inserted/removed
interface RecyclerItemModel<T>: UIModel {
    fun provideId(): T
}