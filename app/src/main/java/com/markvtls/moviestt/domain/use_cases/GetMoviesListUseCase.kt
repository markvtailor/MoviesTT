package com.markvtls.moviestt.domain.use_cases


import com.markvtls.moviestt.data.dto.toDomain
import com.markvtls.moviestt.domain.model.MovieDomain
import com.markvtls.moviestt.domain.repository.MoviesRepository
import javax.inject.Inject

class GetMoviesListUseCase @Inject constructor(
    private val repository: MoviesRepository
){
        suspend operator fun  invoke(): MutableList<MovieDomain> {

            val movies = mutableListOf<MovieDomain>()
            var moviesResponse = repository.getMovies()
            moviesResponse = moviesResponse.sortedWith(compareBy { it.releaseYear }).toMutableList()
            moviesResponse.forEach { movies.add(it.toDomain()) }
            return movies

    }

}