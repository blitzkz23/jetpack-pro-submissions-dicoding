package com.app.academy.ui.academy

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.app.academy.data.source.AcademyRepository
import com.app.academy.data.source.local.entity.CourseEntity
import com.app.academy.data.source.local.entity.CourseWithModule
import com.app.academy.utils.DataDummy
import com.app.academy.vo.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AcademyViewModelTest {

	private lateinit var viewModel: AcademyViewModel

	@get:Rule
	var instanTaskExecutorRule = InstantTaskExecutorRule()

	@Mock
	private lateinit var academyRepository: AcademyRepository

	@Mock
	private lateinit var observer: Observer<Resource<List<CourseEntity>>>

	@Before
	fun setUp() {
		viewModel = AcademyViewModel(academyRepository)
	}

	@Test
	fun getCourses() {
		val dummyCourses = Resource.success(DataDummy.generateDummyCourses())
		val courses = MutableLiveData<Resource<List<CourseEntity>>>()
		courses.value = dummyCourses

		`when`(academyRepository.getAllCourses()).thenReturn(courses)
		val courseEntities = viewModel.getCourses().value?.data
		verify(academyRepository).getAllCourses()
		assertNotNull(courseEntities)
		assertEquals(5, courseEntities?.size)

		viewModel.getCourses().observeForever(observer)
		verify(observer).onChanged(dummyCourses)
	}
}