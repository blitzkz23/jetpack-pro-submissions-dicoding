package com.app.themoviedatabase.di

import android.content.Context
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.remote.RemoteDataSource

object Injection {
	fun provideRepository(context: Context): MovieDbRepository {
		val remoteRepository = RemoteDataSource.getInstance()

		return MovieDbRepository.getInstance(remoteRepository)
	}
}