package com.sinaseyfi.kiliaroalbum.ui.base

interface OnRecyclerItemClickListener<in I: RecyclerItemModel<*>> {
    fun onItemClicked(item: I, position: Int? = null)
}