package com.sinaseyfi.kiliaroalbum.ui.album

import com.sinaseyfi.kiliaroalbum.databinding.LayoutAlbumListItemBinding
import com.sinaseyfi.kiliaroalbum.ui.album.model.Album
import com.sinaseyfi.kiliaroalbum.ui.base.BaseViewHolder
import com.sinaseyfi.kiliaroalbum.utils.humanReadableByteCountBin
import com.sinaseyfi.kiliaroalbum.utils.loadFromUrl

class AlbumListItemViewHolder(
    private val viewBinding: LayoutAlbumListItemBinding
): BaseViewHolder<Album>(viewBinding) {
    override fun bind(model: Album) {
        viewBinding.apply {
            sizeTv.text = humanReadableByteCountBin(model.size.toLong())
            thumbnailIv.loadFromUrl(model.thumbnailUrl)
            thumbnailIv.setOnClickListener {
                onRecyclerItemClickListener?.onItemClicked(model, adapterPosition)
            }
        }
    }
}