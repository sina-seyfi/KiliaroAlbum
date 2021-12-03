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
        viewBinding.apply {
            imageLoading.setVisibility(true)
            detailsTv.setVisibility(false)
            imageIv.loadFromUrl(
                args.album.downloadUrl,
                error = { imageLoading.setVisibility(false) },
                success = {
                    imageLoading.setVisibility(false)
                    detailsTv.setVisibility(true)
                }
            )
            detailsTv.text = detailsTextProvider(args.album)
        }
    }

    private fun detailsTextProvider(album: Album): String =
        "${getString(R.string.created_at_placeholder, album.createdAt)}\n${getString(R.string.size_placeholder, humanReadableByteCountBin(album.size.toLong()))}"

    override fun renderView(state: ImageState) {
    }

    override fun createViewBinding(layoutInflater: LayoutInflater): FragmentImageBinding =
        FragmentImageBinding.inflate(layoutInflater)

}