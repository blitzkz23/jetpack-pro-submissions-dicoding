package com.app.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.app.academy.data.source.local.entity.CourseEntity
import com.app.academy.data.source.AcademyRepository

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

	fun getCourses(): List<CourseEntity> = academyRepository.getAllCourses()
}