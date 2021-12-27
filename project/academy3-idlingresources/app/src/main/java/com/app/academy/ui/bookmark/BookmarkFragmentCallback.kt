package com.app.academy.ui.bookmark

import com.app.academy.data.source.local.entity.CourseEntity

interface BookmarkFragmentCallback {
	fun onShareClick(course: CourseEntity)
}
