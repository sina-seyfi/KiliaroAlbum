package com.sinaseyfi.kiliaroalbum.ui.image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sinaseyfi.kiliaroalbum.R
import com.sinaseyfi.kiliaroalbum.databinding.FragmentImageBinding
import com.sinaseyfi.kiliaroalbum.ui.album.model.Album
import com.sinaseyfi.kiliaroalbum.ui.base.BaseFragment
import com.sinaseyfi.kiliaroalbum.utils.humanReadableByteCountBin
import com.sinaseyfi.kiliaroalbum.utils.loadFromUrl
import com.sinaseyfi.kiliaroalbum.utils.setVisibility

class ImageFragment: Fragment() {

    private val args: ImageFragmentArgs by navArgs()
    private lateinit var viewBinding: FragmentImageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentImageBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

}