package com.app.academy.ui.detail

import com.app.academy.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before

import org.junit.Test

class DetailCourseViewModelTest {
	private lateinit var viewModel: DetailCourseViewModel
	private val dummyCourse = DataDummy.generateDummyCourses()[0]
	private val courseId = dummyCourse.courseId

	@Before
	fun setUp() {
		viewModel = DetailCourseViewModel()
		viewModel.setSelectedCourse(courseId)
	}

	@Test
	fun getCourse() {
		viewModel.setSelectedCourse(courseId)
		val courseEntity = viewModel.getCourse()
		assertNotNull(courseEntity)
		assertEquals(dummyCourse.courseId, courseEntity.courseId)
		assertEquals(dummyCourse.deadline, courseEntity.deadline)
		assertEquals(dummyCourse.description, courseEntity.description)
		assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
		assertEquals(dummyCourse.title, courseEntity.title)
	}

	@Test
	fun getModules() {
		val moduleEntities = viewModel.getModules()
		assertNotNull(moduleEntities)
		assertEquals(7, moduleEntities.size.toLong())
	}
}