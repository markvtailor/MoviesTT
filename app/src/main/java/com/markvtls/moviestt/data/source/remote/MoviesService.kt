package com.markvtls.moviestt.data.source.remote

import com.markvtls.moviestt.data.dto.Response
import retrofit2.http.GET


interface MoviesService {

    @GET("intership-wellcome-task/main/films.json")
    suspend fun getMoviesList(): Response
}