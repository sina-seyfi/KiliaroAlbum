package com.sinaseyfi.kiliaroalbum.data.album.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao {

    @Insert(entity = AlbumTable::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<AlbumTable>)

    @Query("select * from album")
    fun getAll(): Flow<List<AlbumTable>>

    @Query("delete from album")
    suspend fun clearAll()

}