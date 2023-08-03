package com.sinaseyfi.kiliaroalbum.ui.album

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sinaseyfi.kiliaroalbum.ui.base.BaseFragment
import com.sinaseyfi.kiliaroalbum.databinding.FragmentAlbumBinding
import com.sinaseyfi.kiliaroalbum.ui.album.model.Album
import com.sinaseyfi.kiliaroalbum.ui.base.OnRecyclerItemClickListener
import com.sinaseyfi.kiliaroalbum.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumFragment : BaseFragment<AlbumState, AlbumViewModel, FragmentAlbumBinding>() {

    companion object {
        const val ALBUM_LIST_COLUMN_SIZE = 3
    }

    override val viewModel: AlbumViewModel by viewModels()

    private lateinit var albumListAdapter: AlbumListAdapter

    override fun init() {
        super.init()
        albumListAdapter = AlbumListAdapter(onAlbumImageClickListener)
        viewBinding.apply {
            albumListRv.apply {
                layoutManager = GridLayoutManager(
                    requireContext(),
                    ALBUM_LIST_COLUMN_SIZE,
                    RecyclerView.VERTICAL,
                    false
                )
                addItemDecoration(GridItemDecoration(requireContext(), ALBUM_LIST_COLUMN_SIZE, insetStartAndEnd = false))
                adapter = albumListAdapter
            }
        }
        viewModel.fetchAlbums()
    }

    private val onAlbumImageClickListener = object: OnRecyclerItemClickListener<Album> {

        override fun onItemClicked(item: Album, position: Int?) {
            navController.navigate(
                AlbumFragmentDirections.actionAlbumFragmentToImageFragment(item)
            )
        }

    }

    override fun renderView(state: AlbumState) {
        when(state) {
            is AlbumState.AlbumError -> {
                if(state.failedToSync) {
                    showToast("Failed to sync data with server")
                } else {
                    showToast("Some error happened!")
                }
            }
            AlbumState.AlbumLoading -> {
                showToast("Syncing with server")
            }
            is AlbumState.AlbumSuccessfullyLoaded -> {
                albumListAdapter.submitList(state.albums)
            }
        }
    }

    override fun createViewBinding(layoutInflater: LayoutInflater): FragmentAlbumBinding =
        FragmentAlbumBinding.inflate(layoutInflater)

}