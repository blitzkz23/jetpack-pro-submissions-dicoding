package com.app.themoviedatabase.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
import com.app.themoviedatabase.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

	private lateinit var viewModel: TvShowViewModel

	@get:Rule
	var instantTaskExecutorRule = InstantTaskExecutorRule()

	@Mock
	private lateinit var movieDbRepository: MovieDbRepository

	@Mock
	private lateinit var observer: Observer<List<TvShowEntity>>


	@Before
	fun setUp() {
		viewModel = TvShowViewModel(movieDbRepository)
	}

	@Test
	fun getTvShows() {
		val dummyTvShow = DataDummy.generateDummyTvShows()
		val tvShow = MutableLiveData<List<TvShowEntity>>()
		tvShow.value = dummyTvShow

		`when`(movieDbRepository.getAllPopularTvShows()).thenReturn(tvShow)
		val tvShowEntities = viewModel.getTvShows().value
		Mockito.verify(movieDbRepository).getAllPopularTvShows()
		assertNotNull(tvShowEntities)
		assertEquals(5, tvShowEntities?.size)

		viewModel.getTvShows().observeForever(observer)
		Mockito.verify(observer).onChanged(dummyTvShow)
	}
}