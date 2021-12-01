package com.sinaseyfi.kiliaroalbum.di

import com.sinaseyfi.kiliaroalbum.data.album.repository.AlbumRepository
import com.sinaseyfi.kiliaroalbum.data.album.repository.AlbumRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    @Singleton
    abstract fun bindAlbumRepository(albumRepositoryImpl: AlbumRepositoryImpl): AlbumRepository

}