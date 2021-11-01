package com.app.themoviedatabase.ui.detail.movie

import androidx.lifecycle.ViewModel
import com.app.themoviedatabase.data.MovieEntity
import com.app.themoviedatabase.ui.utils.DataDummy

class DetailMovieViewModel : ViewModel() {
	private lateinit var movieId: String

	fun setSelectedMovie(movieId: String) {
		this.movieId = movieId
	}

	fun getMovie(): MovieEntity {
		lateinit var movie: MovieEntity
		val movieEntities = DataDummy.generateDummyMovies()
		for (movieEntity in movieEntities) {
			if (movieEntity.movieId == movieId) {
				movie = movieEntity
			}
		}
		return movie
	}
}