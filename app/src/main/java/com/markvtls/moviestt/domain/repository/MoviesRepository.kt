package com.markvtls.moviestt.domain.repository

import com.markvtls.moviestt.data.dto.Movie

interface MoviesRepository {

    suspend fun getMovies(): List<Movie>
}