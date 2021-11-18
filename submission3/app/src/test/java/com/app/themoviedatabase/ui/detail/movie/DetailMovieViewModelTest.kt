package com.app.themoviedatabase.ui.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.utils.DataDummy
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
class DetailMovieViewModelTest {

	private lateinit var viewModel: DetailMovieViewModel
	private val dummyMovies = DataDummy.generateDummyMovies()[0]
	private val movieId = dummyMovies.movieId

	@get:Rule
	var instantTaskExecutorRule = InstantTaskExecutorRule()

	@Mock
	private lateinit var movieDbRepository: MovieDbRepository

	@Mock
	private lateinit var observer: Observer<MovieEntity>

	@Before
	fun setUp() {
		viewModel = DetailMovieViewModel(movieDbRepository)
		viewModel.setSelectedMovie(movieId)
	}

	@Test
	fun getMovie() {
		val movie = MutableLiveData<MovieEntity>()
		movie.value = dummyMovies

		`when`(movieDbRepository.getMovieById(movieId)).thenReturn(movie)
		viewModel.movieDetail.observeForever(observer)
		verify(observer).onChanged(movie.value)
	}
}