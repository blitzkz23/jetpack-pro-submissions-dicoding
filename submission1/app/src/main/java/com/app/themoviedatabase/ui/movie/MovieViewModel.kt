package com.app.themoviedatabase.ui.movie

import androidx.lifecycle.ViewModel
import com.app.themoviedatabase.data.MovieEntity
import com.app.themoviedatabase.ui.utils.DataDummy

class MovieViewModel : ViewModel() {

	fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovies()
}