package com.app.academy.ui.bookmark

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.app.academy.data.source.AcademyRepository
import com.app.academy.data.source.local.entity.CourseEntity
import com.app.academy.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkViewModelTest {

	private lateinit var viewModel: BookmarkViewModel

	@get:Rule
	var instantTaskExecutorRule = InstantTaskExecutorRule()

	@Mock
	private lateinit var academyRepository: AcademyRepository

	@Mock
	private lateinit var observer: Observer<List<CourseEntity>>

	@Before
	fun setUp() {
		viewModel = BookmarkViewModel(academyRepository)
	}

	@Test
	fun getBookmark() {
		val dummyCourse = DataDummy.generateDummyCourses()
		val course = MutableLiveData<List<CourseEntity>>()
		course.value = dummyCourse

		Mockito.`when`(academyRepository.getBookmarkedCourses()).thenReturn(course)
		val courseEntities = viewModel.getBookmarks().value
		Mockito.verify(academyRepository).getBookmarkedCourses()
		assertNotNull(courseEntities)
		assertEquals(5, courseEntities?.size)
	}
}