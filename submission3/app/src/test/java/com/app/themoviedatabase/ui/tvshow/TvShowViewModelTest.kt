package com.app.themoviedatabase.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
import com.dicoding.academies.vo.Resource
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
	private lateinit var observer: Observer<Resource<PagedList<TvShowEntity>>>

	@Mock
	private lateinit var pagedList: PagedList<TvShowEntity>


	@Before
	fun setUp() {
		viewModel = TvShowViewModel(movieDbRepository)
	}

	@Test
	fun getTvShows() {
		val dummyTvShows = Resource.success(pagedList)
		`when`(dummyTvShows.data?.size).thenReturn(5)
		val tvShows = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
		tvShows.value = dummyTvShows

		`when`(movieDbRepository.getAllPopularTvShows()).thenReturn(tvShows)
		val tvShowsEntities = viewModel.getTvShows().value?.data
		Mockito.verify(movieDbRepository).getAllPopularTvShows()
		assertNotNull(tvShowsEntities)
		assertEquals(5, tvShowsEntities?.size)

		viewModel.getTvShows().observeForever(observer)
		Mockito.verify(observer).onChanged(dummyTvShows)
	}
}