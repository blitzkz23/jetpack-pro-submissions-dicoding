package com.app.academy.data.source.remote

import com.app.academy.data.source.remote.response.ContentResponse
import com.app.academy.data.source.remote.response.CourseResponse
import com.app.academy.data.source.remote.response.ModuleResponse
import com.app.academy.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

	companion object {
		@Volatile
		private var instance: RemoteDataSource? = null

		// instance berfungsi untuk membuat kelas RemoteDataSource menjadi Singleton
		fun getInstance(helper: JsonHelper): RemoteDataSource =
			instance ?: synchronized(this) {
				instance ?: RemoteDataSource(helper).apply { instance = this }
			}
	}

	fun getAllCourses(): List<CourseResponse> = jsonHelper.loadCourses()

	fun getModules(courseId: String): List<ModuleResponse> = jsonHelper.loadModule(courseId)

	fun getContent(moduleId: String): ContentResponse = jsonHelper.loadContent(moduleId)
}