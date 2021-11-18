package com.app.themoviedatabase.ui.favorites.favoritetvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
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
class FavoriteTvShowViewModelTest {

	private lateinit var viewModel: FavoriteTvShowViewModel

	@get:Rule
	var instantTaskExecutorRule = InstantTaskExecutorRule()

	@Mock
	private lateinit var movieDbRepository: MovieDbRepository

	@Mock
	private lateinit var observer: Observer<PagedList<TvShowEntity>>

	@Mock
	private lateinit var pagedList: PagedList<TvShowEntity>

	@Before
	fun setUp() {
		viewModel = FavoriteTvShowViewModel(movieDbRepository)
	}

	@Test
	fun getFavouritedTvShows() {
		val dummyTvShows = pagedList
		`when`(dummyTvShows.size).thenReturn(5)
		val tvShows = MutableLiveData<PagedList<TvShowEntity>>()
		tvShows.value = dummyTvShows

		`when`(movieDbRepository.getFavouritedTvShows()).thenReturn(tvShows)
		val tvShowEntities = viewModel.getFavouritedTvShows().value
		verify<MovieDbRepository>(movieDbRepository).getFavouritedTvShows()
		assertNotNull(tvShowEntities)
		assertEquals(5, tvShowEntities?.size)

		viewModel.getFavouritedTvShows().observeForever(observer)
		verify(observer).onChanged(dummyTvShows)
	}
}