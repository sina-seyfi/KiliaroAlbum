package com.sinaseyfi.kiliaroalbum.di

import com.sinaseyfi.kiliaroalbum.data.album.repository.AlbumRepository
import com.sinaseyfi.kiliaroalbum.data.album.repository.AlbumRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [ApiModule::class, RepoModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
object DataModule {  }