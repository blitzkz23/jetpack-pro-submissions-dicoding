package com.app.themoviedatabase.ui.movie

import androidx.lifecycle.ViewModel
import com.app.themoviedatabase.data.local.entity.MovieEntity
import com.app.themoviedatabase.utils.DataDummy

class MovieViewModel : ViewModel() {

	fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovies()
}