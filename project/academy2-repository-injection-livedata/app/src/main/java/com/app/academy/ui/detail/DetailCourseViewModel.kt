package com.app.academy.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.academy.data.source.local.entity.CourseEntity
import com.app.academy.data.source.local.entity.ModuleEntity
import com.app.academy.data.source.AcademyRepository

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
	private lateinit var courseId: String

	fun setSelectedCourse(courseId: String) {
		this.courseId = courseId
	}

	fun getCourse(): LiveData<CourseEntity> = academyRepository.getCourseWithModules(courseId)

	fun getModules(): LiveData<List<ModuleEntity>> = academyRepository.getAllModulesByCourse(courseId)
}