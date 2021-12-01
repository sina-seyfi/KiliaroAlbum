package com.sinaseyfi.kiliaroalbum.data.album.database

import com.sinaseyfi.kiliaroalbum.data.album.model.AlbumModel
import com.sinaseyfi.kiliaroalbum.data.base.database.TableMapper
import javax.inject.Inject

class AlbumTableMapper @Inject constructor(): TableMapper<AlbumTable, AlbumModel> {

    override fun mapToModel(table: AlbumTable): AlbumModel =
        AlbumModel(
            table.id,
            table.userId,
            table.mediaType,
            table.fileName,
            table.size,
            table.createdAt,
            table.takenAt,
            table.guessedTakenAt,
            table.md5sum,
            table.contentType,
            table.video,
            table.thumbnailUrl,
            table.downloadUrl,
            table.resx,
            table.resy
        )

    override fun mapToTable(model: AlbumModel): AlbumTable =
        AlbumTable(
            model.id,
            model.userId,
            model.mediaType,
            model.fileName,
            model.size,
            model.createdAt,
            model.takenAt,
            model.guessedTakenAt,
            model.md5sum,
            model.contentType,
            model.video,
            model.thumbnailUrl,
            model.downloadUrl,
            model.resx,
            model.resy
        )

}