package com.markvtls.moviestt.di

import com.markvtls.moviestt.domain.repository.MoviesRepository
import com.markvtls.moviestt.domain.use_cases.GetMoviesListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMoviesListUseCase(repository: MoviesRepository): GetMoviesListUseCase {
        return GetMoviesListUseCase(repository)
    }

}