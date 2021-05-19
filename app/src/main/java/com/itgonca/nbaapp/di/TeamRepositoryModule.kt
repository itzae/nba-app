package com.itgonca.nbaapp.di

import com.itgonca.nbaapp.features.home.data.network.api.TeamsApi
import com.itgonca.nbaapp.features.home.data.network.repository.TeamsRepository
import com.itgonca.nbaapp.features.home.data.network.repository.TeamsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TeamRepositoryModule{
    @Singleton
    @Provides
    fun provideTeamsRepository(teamsApi: TeamsApi):TeamsRepository = TeamsRepositoryImpl(teamsApi)
}