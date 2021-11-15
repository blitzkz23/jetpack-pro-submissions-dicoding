package com.app.academy.di

import android.content.Context
import com.app.academy.data.source.AcademyRepository
import com.app.academy.data.source.local.LocalDataSource
import com.app.academy.data.source.local.room.AcademyDatabase
import com.app.academy.data.source.remote.RemoteDataSource
import com.app.academy.utils.AppExecutors
import com.app.academy.utils.JsonHelper

object Injection {
	fun provideRepository(context: Context): AcademyRepository {

		val database = AcademyDatabase.getInstance(context)

		val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
		val localDataSource = LocalDataSource.getInstance(database.academyDao())
		val appExecutors = AppExecutors()

		return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
	}
}