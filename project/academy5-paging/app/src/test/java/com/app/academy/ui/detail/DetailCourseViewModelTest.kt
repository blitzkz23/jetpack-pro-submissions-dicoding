package com.app.academy.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.app.academy.data.source.AcademyRepository
import com.app.academy.data.source.local.entity.CourseEntity
import com.app.academy.data.source.local.entity.CourseWithModule
import com.app.academy.data.source.local.entity.ModuleEntity
import com.app.academy.utils.DataDummy
import com.app.academy.vo.Resource
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailCourseViewModelTest {
	private lateinit var viewModel: DetailCourseViewModel
	private val dummyCourse = DataDummy.generateDummyCourses()[0]
	private val courseId = dummyCourse.courseId

	@get:Rule
	var instantTaskExecutorRule = InstantTaskExecutorRule()

	@Mock
	private lateinit var academyRepository: AcademyRepository

	@Mock
	private lateinit var courseObserver: Observer<CourseEntity>

	@Mock
	private lateinit var observer: Observer<Resource<CourseWithModule>>

	@Before
	fun setUp() {
		viewModel = DetailCourseViewModel(academyRepository)
		viewModel.setSelectedCourse(courseId)
	}

	@Test
	fun getCourseWithModule() {
		val dummyCourseWithModule = Resource.success(DataDummy.generateDummyCourseWithModules(dummyCourse, true))
		val course = MutableLiveData<Resource<CourseWithModule>>()
		course.value = dummyCourseWithModule
		`when`(academyRepository.getCourseWithModules(courseId)).thenReturn(course)
		viewModel.courseModule.observeForever(observer)
		verify(observer).onChanged(dummyCourseWithModule)
	}
}