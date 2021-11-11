package com.app.academy.data.source

import androidx.lifecycle.LiveData
import com.app.academy.data.source.local.entity.CourseEntity
import com.app.academy.data.source.local.entity.CourseWithModule
import com.app.academy.data.source.local.entity.ModuleEntity
import com.app.academy.vo.Resource

interface AcademyDataSource {

//	fun getAllCourses(): LiveData<List<CourseEntity>>
//
//	fun getBookmarkedCourses(): LiveData<List<CourseEntity>>
//
//	fun getCourseWithModules(courseId: String): LiveData<CourseEntity>
//
//	fun getAllModulesByCourse(courseId: String): LiveData<List<ModuleEntity>>
//
//	fun getContent(courseId: String, moduleId: String): LiveData<ModuleEntity>

	fun getAllCourses(): LiveData<Resource<List<CourseEntity>>>

	fun getCourseWithModules(courseId: String): LiveData<Resource<CourseWithModule>>

	fun getAllModulesByCourse(courseId: String): LiveData<Resource<List<ModuleEntity>>>

	fun getContent(moduleId: String): LiveData<Resource<ModuleEntity>>

	fun getBookmarkedCourses(): LiveData<List<CourseEntity>>

	fun setCourseBookmark(course: CourseEntity, state: Boolean)

	fun setReadModule(module: ModuleEntity)
}