package com.sinaseyfi.kiliaroalbum.di

import com.sinaseyfi.kiliaroalbum.data.album.database.AlbumLocalSource
import com.sinaseyfi.kiliaroalbum.data.album.database.AlbumLocalSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule {

    @Binds
    @Singleton
    abstract fun bindAlbumLocalSourceImpl(localSourceImpl: AlbumLocalSourceImpl): AlbumLocalSource

}