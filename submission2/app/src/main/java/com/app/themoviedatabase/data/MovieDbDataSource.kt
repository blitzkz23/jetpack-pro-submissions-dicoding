package com.app.themoviedatabase.data

import androidx.lifecycle.LiveData
import com.app.themoviedatabase.data.source.local.entity.MovieEntity

interface MovieDbDataSource {

	fun getAllPopularMovies(): LiveData<List<MovieEntity>>
}