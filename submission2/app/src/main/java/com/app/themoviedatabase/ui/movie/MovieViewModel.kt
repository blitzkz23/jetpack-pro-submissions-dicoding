package com.app.themoviedatabase.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.MovieEntity

class MovieViewModel(private val movieDbRepository: MovieDbRepository) : ViewModel() {

	fun getMovies(): LiveData<List<MovieEntity>> = movieDbRepository.getAllPopularMovies()
}