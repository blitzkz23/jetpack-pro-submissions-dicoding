package com.app.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.app.academy.data.CourseEntity
import com.app.academy.utils.DataDummy

class BookmarkViewModel : ViewModel() {

	fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}