package com.app.themoviedatabase.di

import android.content.Context
import com.app.themoviedatabase.data.MoviedbRepository
import com.app.themoviedatabase.data.source.remote.RemoteDataSource

object Injection {
	fun provideRepository(context: Context): MoviedbRepository {
		val remoteRepository = RemoteDataSource.getInstance()

		return MoviedbRepository.getInstance(remoteRepository)
	}
}