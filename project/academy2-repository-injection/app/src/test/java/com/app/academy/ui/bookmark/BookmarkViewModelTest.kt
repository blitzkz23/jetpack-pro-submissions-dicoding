package com.app.academy.ui.bookmark

import com.app.academy.data.source.AcademyRepository
import com.app.academy.data.source.local.entity.CourseEntity
import com.app.academy.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkViewModelTest {

	private lateinit var viewModel: BookmarkViewModel

	@Mock
	private lateinit var academyRepository: AcademyRepository

	@Before
	fun setUp() {
		viewModel = BookmarkViewModel(academyRepository)
	}

	@Test
	fun getBookmark() {
		Mockito.`when`(academyRepository.getBookmarkedCourses()).thenReturn(DataDummy.generateDummyCourses() as ArrayList<CourseEntity>)
		val courseEntities = viewModel.getBookmarks()
		Mockito.verify<AcademyRepository>(academyRepository).getBookmarkedCourses()
		assertNotNull(courseEntities)
		assertEquals(5, courseEntities.size)
	}
}