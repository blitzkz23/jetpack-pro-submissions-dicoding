package com.app.themoviedatabase.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.MovieEntity

class DetailMovieViewModel(private val movieDbRepository: MovieDbRepository) : ViewModel() {
	private var movieId = MutableLiveData<Int>()

	fun setSelectedMovie(movieId: Int) {
		this.movieId.value = movieId
	}

	var movieDetail: LiveData<MovieEntity> = Transformations.switchMap(movieId) { mMovieId ->
		movieDbRepository.getMovieById(mMovieId)
	}

	fun setFavorited() {
		val movieEntity = movieDetail.value
		if (movieEntity != null) {
			val newState = !movieEntity.favourited
			movieDbRepository.setFavoriteMovie(movieEntity, newState)
		}
	}
}