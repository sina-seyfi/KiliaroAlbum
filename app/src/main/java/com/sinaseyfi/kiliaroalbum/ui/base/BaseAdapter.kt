package com.sinaseyfi.kiliaroalbum.ui.base

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<Model: RecyclerItemModel<*>>(
    dataList: MutableList<Model>? = null,
        // This is the listener for handling click of each item
        val onRecyclerItemClickListener: OnRecyclerItemClickListener<Model>? = null,
        /*
        Diff utils is automatically set to handler changes in the list
         */
        diffUtil: DiffUtil.ItemCallback<Model> = object: DiffUtil.ItemCallback<Model>() {
            override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean =
                oldItem.provideId() == newItem.provideId()
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean =
                oldItem == newItem
        }
): ListAdapter<Model, BaseViewHolder<Model>>(diffUtil) {

    init { dataList?.let { submitList(it) } }

    override fun onBindViewHolder(holder: BaseViewHolder<Model>, position: Int) {
        holder.onRecyclerItemClickListener = onRecyclerItemClickListener
        holder.bind(getItem(position))
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder<Model>) {
        holder.attachedToWindow = true
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<Model>) {
        holder.attachedToWindow = false
    }

}