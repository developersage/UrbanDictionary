package com.sangdo.repository.di

import com.sangdo.repository.SangdoUrbanRepository
import com.sangdo.repository.UrbanRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindUrbanRepository(repository: SangdoUrbanRepository): UrbanRepository
}