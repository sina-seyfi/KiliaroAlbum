package com.sinaseyfi.kiliaroalbum.data.album.database

import com.sinaseyfi.kiliaroalbum.data.album.validator.AlbumSourceValidator
import com.sinaseyfi.kiliaroalbum.data.base.database.Database
import com.sinaseyfi.kiliaroalbum.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class AlbumLocalSourceImpl @Inject constructor(
    private val database: Database,
    private val albumSourceValidator: AlbumSourceValidator
): AlbumLocalSource {

    override fun getAllAlbumTable(): Flow<Resource<List<AlbumTable>>> =
        database.database.getAlbumDao().getAll()
            .map { Resource.success(it) }
            .onStart { emit(Resource.loading()) }
            .catch { exception -> emit(Resource.error(exception, null)) }

    override suspend fun insertAllAlbumTable(list: List<AlbumTable>) {
        database.database.getAlbumDao().insertAll(list)
    }

    override suspend fun clearAlbumTable() {
        database.database.getAlbumDao().clearAll()
    }

}