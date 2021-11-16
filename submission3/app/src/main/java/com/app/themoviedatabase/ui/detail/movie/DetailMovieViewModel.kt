package com.app.themoviedatabase.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.MovieEntity

class DetailMovieViewModel(private val movieDbRepository: MovieDbRepository) : ViewModel() {
	private var movieId: Int = 0

	fun setSelectedMovie(movieId: Int) {
		this.movieId = movieId
	}

	fun getMovie(): LiveData<MovieEntity> = movieDbRepository.getPopularMovieById(movieId)

}