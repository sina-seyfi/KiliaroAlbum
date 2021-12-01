package com.sinaseyfi.kiliaroalbum.ui.album.model

import com.sinaseyfi.kiliaroalbum.data.album.model.AlbumModel
import com.sinaseyfi.kiliaroalbum.ui.base.ModelMapper
import javax.inject.Inject

class AlbumModelMapper @Inject constructor(): ModelMapper<AlbumModel, Album> {
    override fun mapToUIModel(model: AlbumModel): Album =
        Album(
            model.id,
            model.size,
            model.createdAt,
            model.thumbnailUrl,
            model.downloadUrl
        )
}