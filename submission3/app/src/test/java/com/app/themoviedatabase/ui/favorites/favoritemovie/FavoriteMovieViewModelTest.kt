package com.app.themoviedatabase.ui.favorites.favoritemovie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
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
class FavoriteMovieViewModelTest {

	private lateinit var viewModel: FavoriteMovieViewModel

	@get:Rule
	var instantTaskExecutorRule = InstantTaskExecutorRule()

	@Mock
	private lateinit var movieDbRepository: MovieDbRepository

	@Mock
	private lateinit var observer: Observer<PagedList<MovieEntity>>

	@Mock
	private lateinit var pagedList: PagedList<MovieEntity>

	@Before
	fun setUp() {
		viewModel = FavoriteMovieViewModel(movieDbRepository)
	}

	@Test
	fun getFavoriteMovies() {
		val dummyMovies = pagedList
		`when`(dummyMovies.size).thenReturn(5)
		val movies = MutableLiveData<PagedList<MovieEntity>>()
		movies.value = dummyMovies

		`when`(movieDbRepository.getFavouritedMovies()).thenReturn(movies)
		val movieEntities = viewModel.getFavoriteMovies().value
		verify<MovieDbRepository>(movieDbRepository).getFavouritedMovies()
		assertNotNull(movieEntities)
		assertEquals(5, movieEntities?.size)

		viewModel.getFavoriteMovies().observeForever(observer)
		verify(observer).onChanged(dummyMovies)
	}
}