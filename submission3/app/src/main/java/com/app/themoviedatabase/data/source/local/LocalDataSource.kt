package com.app.themoviedatabase.data.source.local

import com.app.themoviedatabase.data.source.local.room.MovieDbDao

class LocalDataSource private constructor(private val mMovieDao: MovieDbDao){
	companion object {
		private var INSTANCE: LocalDataSource? = null

		fun getInstance(movieDbDao: MovieDbDao): LocalDataSource =
			INSTANCE ?: LocalDataSource(movieDbDao)
	}
}