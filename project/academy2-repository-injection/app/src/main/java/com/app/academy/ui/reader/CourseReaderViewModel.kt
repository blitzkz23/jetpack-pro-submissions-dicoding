package com.app.academy.ui.reader

import androidx.lifecycle.ViewModel
import com.app.academy.data.source.local.entity.ModuleEntity
import com.app.academy.data.source.AcademyRepository

class CourseReaderViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

	private lateinit var courseId: String
	private lateinit var moduleId: String

	fun setSelectedCourse(courseId: String) {
		this.courseId = courseId
	}

	fun setSelectedModule(moduleId: String) {
		this.moduleId = moduleId
	}

	fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)

	fun getSelectedModule(): ModuleEntity = academyRepository.getContent(courseId, moduleId)
}