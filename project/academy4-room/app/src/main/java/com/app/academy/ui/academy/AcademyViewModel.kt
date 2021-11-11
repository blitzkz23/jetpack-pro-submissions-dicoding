package com.app.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.academy.data.source.local.entity.CourseEntity
import com.app.academy.data.source.AcademyRepository
import com.app.academy.vo.Resource

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

	fun getCourses(): LiveData<Resource<List<CourseEntity>>> = academyRepository.getAllCourses()
}