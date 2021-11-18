package com.app.themoviedatabase.ui.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
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
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {

	private lateinit var viewModel: DetailTvShowViewModel
	private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
	private val tvShowId = dummyTvShow.tvShowId

	@get:Rule
	var instantTaskExecutorRule = InstantTaskExecutorRule()

	@Mock
	private lateinit var movieDbRepository: MovieDbRepository

	@Mock
	private lateinit var observer: Observer<TvShowEntity>

	@Before
	fun setUp() {
		viewModel = DetailTvShowViewModel(movieDbRepository)
		viewModel.setSelectedTvShow(tvShowId)
	}

	@Test
	fun getTvShow() {
		val tvShow = MutableLiveData<TvShowEntity>()
		tvShow.value = dummyTvShow

		`when`(movieDbRepository.getTvShowById(tvShowId)).thenReturn(tvShow)
		viewModel.tvShowDetail.observeForever(observer)
		verify(observer).onChanged(tvShow.value)
	}
}