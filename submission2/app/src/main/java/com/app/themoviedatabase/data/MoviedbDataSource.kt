package com.app.themoviedatabase.data

import androidx.lifecycle.LiveData
import com.app.themoviedatabase.data.source.local.entity.MovieEntity

interface MoviedbDataSource {

	fun getAllPopularMovies(): LiveData<List<MovieEntity>>
}