package com.sinaseyfi.kiliaroalbum.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [ApiModule::class, RepoModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
object DataModule