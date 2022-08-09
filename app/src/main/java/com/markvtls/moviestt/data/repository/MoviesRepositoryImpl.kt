package com.markvtls.moviestt.data.repository

import com.markvtls.moviestt.data.dto.Movie
import com.markvtls.moviestt.data.source.remote.MoviesService
import com.markvtls.moviestt.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesService: MoviesService
    ): MoviesRepository {

    override suspend fun getMovies(): List<Movie> {
        return try {
            moviesService.getMoviesList().items
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }

    }

}