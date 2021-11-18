package com.app.themoviedatabase.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.dicoding.academies.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

	private lateinit var viewModel: MovieViewModel

	@get:Rule
	var instantTaskExecutorRule = InstantTaskExecutorRule()

	@Mock
	private lateinit var movieDbRepository: MovieDbRepository

	@Mock
	private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

	@Mock
	private lateinit var pagedList: PagedList<MovieEntity>

	@Before
	fun setUp() {
		viewModel = MovieViewModel(movieDbRepository)
	}

	@Test
	fun getMovies() {
		val dummyMovies = Resource.success(pagedList)
		`when`(dummyMovies.data?.size).thenReturn(5)
		val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
		movies.value = dummyMovies

		`when`(movieDbRepository.getAllPopularMovies()).thenReturn(movies)
		val movieEntities = viewModel.getMovies().value?.data
		verify(movieDbRepository).getAllPopularMovies()
		assertNotNull(movieEntities)
		assertEquals(5, movieEntities?.size)

		viewModel.getMovies().observeForever(observer)
		verify(observer).onChanged(dummyMovies)
	}
}