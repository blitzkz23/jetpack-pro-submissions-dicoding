package com.app.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.app.academy.data.CourseEntity
import com.app.academy.utils.DataDummy

class AcademyViewModel : ViewModel() {

	fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()
}