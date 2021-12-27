package com.app.academy.di

import android.content.Context
import com.app.academy.data.source.AcademyRepository
import com.app.academy.data.source.remote.RemoteDataSource
import com.app.academy.utils.JsonHelper

object Injection {
	fun provideRepository(context: Context): AcademyRepository {

		val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

		return AcademyRepository.getInstance(remoteDataSource)
	}
}