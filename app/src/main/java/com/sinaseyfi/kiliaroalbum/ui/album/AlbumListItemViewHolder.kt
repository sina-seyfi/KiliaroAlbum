package com.sinaseyfi.kiliaroalbum.ui.album

import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.sinaseyfi.kiliaroalbum.databinding.LayoutAlbumListItemBinding
import com.sinaseyfi.kiliaroalbum.ui.album.model.Album
import com.sinaseyfi.kiliaroalbum.ui.base.BaseViewHolder
import com.sinaseyfi.kiliaroalbum.utils.humanReadableByteCountBin
import com.sinaseyfi.kiliaroalbum.utils.loadFromUrl
import timber.log.Timber

class AlbumListItemViewHolder(
    private val viewBinding: LayoutAlbumListItemBinding
): BaseViewHolder<Album>(viewBinding) {

    // To store previously loaded ViewTarget and canceling it when detached and release resources
    private var target: Target<*>? = null
    override fun bind(model: Album) {
        viewBinding.apply {
            sizeTv.text = humanReadableByteCountBin(model.size.toLong())
            target = thumbnailIv.loadFromUrl(model.thumbnailUrl)
            thumbnailIv.setOnClickListener {
                onRecyclerItemClickListener?.onItemClicked(model, adapterPosition)
            }
        }
    }

    override fun onViewDetachedFromWindow() {
        Glide.with(context).clear(target)
        Timber.i("On View Detached from window")
        target = null
    }

}