package com.app.themoviedatabase.ui.detail.tvshow

import com.app.themoviedatabase.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class DetailTvShowViewModelTest {

	private lateinit var viewModel: DetailTvShowViewModel
	private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
	private val tvShowId = dummyTvShow.tvShowId

	@Before
	fun setUp() {
		viewModel = DetailTvShowViewModel()
		viewModel.setSelectedTvShow(tvShowId)
	}

	@Test
	fun getTvShow() {
		viewModel.setSelectedTvShow(tvShowId)
		val tvShowEntities = viewModel.getTvShow()
		assertNotNull(tvShowEntities)
		assertEquals(dummyTvShow.tvShowId, tvShowEntities.tvShowId)
		assertEquals(dummyTvShow.title, tvShowEntities.title)
		assertEquals(dummyTvShow.releaseDate, tvShowEntities.releaseDate)
		assertEquals(dummyTvShow.score, tvShowEntities.score)
		assertEquals(dummyTvShow.genre, tvShowEntities.genre)
		assertEquals(dummyTvShow.duration, tvShowEntities.duration)
		assertEquals(dummyTvShow.overview, tvShowEntities.overview)
	}
}