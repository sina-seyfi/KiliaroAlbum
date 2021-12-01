package com.sinaseyfi.kiliaroalbum.ui.base

// T: Unique ID of model to be compared when items inserted/removed
interface RecyclerItemModel<T>: UIModel {
    fun provideId(): T
}

// To automate Long ID that happens lots of times
abstract class RecyclerItemLongIdModel: RecyclerItemModel<Long> {
    abstract val id: Long
    override fun provideId(): Long = id
}