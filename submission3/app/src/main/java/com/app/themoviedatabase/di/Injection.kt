package com.app.themoviedatabase.di

import android.content.Context
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.LocalDataSource
import com.app.themoviedatabase.data.source.local.room.MovieDbDatabase
import com.app.themoviedatabase.data.source.remote.RemoteDataSource
import com.app.themoviedatabase.utils.AppExecutors

/**
 * Injection is used to provide the necessary data source for repository.
 */
object Injection {
	fun provideRepository(context: Context): MovieDbRepository {
		val remoteDataSource = RemoteDataSource.getInstance()

		val database = MovieDbDatabase.getInstance(context)
		val localDataSource = LocalDataSource.getInstance(database.movieDbDao())
		val appExecutors = AppExecutors()


		return MovieDbRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
	}
}