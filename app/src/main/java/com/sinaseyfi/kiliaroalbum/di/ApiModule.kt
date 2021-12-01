package com.sinaseyfi.kiliaroalbum.di

import com.sinaseyfi.kiliaroalbum.data.album.api.AlbumApiService
import com.sinaseyfi.kiliaroalbum.data.album.api.AlbumApiServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiModule {

    @Binds
    @Singleton
    abstract fun bindAlbumApiService(albumApiServiceImpl: AlbumApiServiceImpl): AlbumApiService

}