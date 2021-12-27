package com.app.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.app.academy.data.source.local.entity.CourseEntity
import com.app.academy.data.source.AcademyRepository

class BookmarkViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

	fun getBookmarks(): List<CourseEntity> = academyRepository.getBookmarkedCourses()
}