package com.markvtls.moviestt.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.markvtls.moviestt.domain.model.MovieDomain
import com.markvtls.moviestt.domain.use_cases.GetMoviesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMovies: GetMoviesListUseCase) : ViewModel() {

    private var _movies = MutableLiveData<MutableList<MovieDomain>>()
    val movies get() = _movies


    init {
        getMoviesList()
    }

    fun getMoviesList() { //can be used later thus public
        viewModelScope.launch {
            val response = getMovies().toMutableList()
            movies.value = response
            }
    }

}