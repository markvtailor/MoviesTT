package com.markvtls.moviestt.di

import com.markvtls.moviestt.data.source.remote.MoviesService
import com.markvtls.moviestt.data.repository.MoviesRepositoryImpl
import com.markvtls.moviestt.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideMoviesRepository(moviesService: MoviesService): MoviesRepository {
        return MoviesRepositoryImpl(moviesService)
    }

}