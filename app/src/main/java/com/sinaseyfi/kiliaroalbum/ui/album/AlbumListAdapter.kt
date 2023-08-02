package com.sinaseyfi.kiliaroalbum.ui.album

import android.view.ViewGroup
import com.sinaseyfi.kiliaroalbum.databinding.LayoutAlbumListItemBinding
import com.sinaseyfi.kiliaroalbum.ui.album.model.Album
import com.sinaseyfi.kiliaroalbum.ui.base.BaseAdapter
import com.sinaseyfi.kiliaroalbum.ui.base.BaseViewHolder
import com.sinaseyfi.kiliaroalbum.ui.base.OnRecyclerItemClickListener
import com.sinaseyfi.kiliaroalbum.utils.layoutInflater

class AlbumListAdapter(
    onRecyclerItemClickListener: OnRecyclerItemClickListener<Album>
): BaseAdapter<Album>(onRecyclerItemClickListener = onRecyclerItemClickListener) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Album> =
        AlbumListItemViewHolder(
            LayoutAlbumListItemBinding.inflate(
                parent.layoutInflater,
                parent,
                false
            )
        )

}