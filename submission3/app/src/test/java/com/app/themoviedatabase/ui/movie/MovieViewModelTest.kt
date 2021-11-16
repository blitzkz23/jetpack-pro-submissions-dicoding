package com.app.themoviedatabase.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.utils.DataDummy
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
class MovieViewModelTest {

	private lateinit var viewModel: MovieViewModel

	@get:Rule
	var instantTaskExecutorRule = InstantTaskExecutorRule()

	@Mock
	private lateinit var movieDbRepository: MovieDbRepository

	@Mock
	private lateinit var observer: Observer<List<MovieEntity>>

	@Before
	fun setUp() {
		viewModel = MovieViewModel(movieDbRepository)
	}

	@Test
	fun getMovies() {
		val dummyMovies = DataDummy.generateDummyMovies()
		val movies = MutableLiveData<List<MovieEntity>>()
		movies.value = dummyMovies

		`when`(movieDbRepository.getAllPopularMovies()).thenReturn(movies)
		val movieEntities = viewModel.getMovies().value
		verify(movieDbRepository).getAllPopularMovies()
		assertNotNull(movieEntities)
		assertEquals(5, movieEntities?.size)

		viewModel.getMovies().observeForever(observer)
		verify(observer).onChanged(dummyMovies)
	}
}