package com.sinaseyfi.kiliaroalbum.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [ApiModule::class, RepoModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
object DataModule {

    // Every DI config that doesn't fit into ApiModule, RepoModule and DatabaseModule goes here...
    // In this way we can have multiple ApiModule, RepoModule, DatabaseModule and include them base on our needs
    // For example: We could have DemoApiModule or ApiModuleV2 and pass it here

}