package com.app.academy.ui.bookmark

import com.app.academy.data.CourseEntity

interface BookmarkFragmentCallback {
	fun onShareClick(course: CourseEntity)
}
