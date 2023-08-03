package com.sinaseyfi.kiliaroalbum.ui.image

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sinaseyfi.kiliaroalbum.R
import com.sinaseyfi.kiliaroalbum.databinding.FragmentImageBinding
import com.sinaseyfi.kiliaroalbum.ui.album.model.Album
import com.sinaseyfi.kiliaroalbum.ui.base.BaseFragment
import com.sinaseyfi.kiliaroalbum.utils.humanReadableByteCountBin
import com.sinaseyfi.kiliaroalbum.utils.loadFromUrl
import com.sinaseyfi.kiliaroalbum.utils.setVisibility

class ImageFragment: BaseFragment<ImageState, ImageViewModel, FragmentImageBinding>() {

    override val viewModel: ImageViewModel by viewModels()

    private val args: ImageFragmentArgs by navArgs()

    override fun init() {
        super.init()
        viewModel.setImageIsLoading()
        viewBinding.apply {
            imageIv.loadFromUrl(
                args.album.downloadUrl,
                error = { viewModel.setImageFailedToLoad() },
                success = { viewModel.setImageLoaded() }
            )
            detailsTv.text = detailsTextProvider(args.album)
        }
    }

    private fun detailsTextProvider(album: Album): String =
        "${getString(R.string.created_at_placeholder, album.createdAt)}\n${getString(R.string.size_placeholder, humanReadableByteCountBin(album.size.toLong()))}"

    override fun renderView(state: ImageState) {
        when(state) {
            ImageState.ImageError -> {
                viewBinding.imageLoading.setVisibility(false)
            }
            ImageState.ImageLoaded -> {
                viewBinding.apply {
                    imageLoading.setVisibility(false)
                    detailsTv.setVisibility(true)
                }
            }
            ImageState.ImageLoading -> {
                viewBinding.apply {
                    imageLoading.setVisibility(true)
                    detailsTv.setVisibility(false)
                }
            }
        }
    }

    override fun createViewBinding(layoutInflater: LayoutInflater): FragmentImageBinding =
        FragmentImageBinding.inflate(layoutInflater)

}