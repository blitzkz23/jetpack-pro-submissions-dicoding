package com.app.themoviedatabase.ui.tvshow

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class TvShowViewModelTest {

	private lateinit var viewModel: TvShowViewModel

	@Before
	fun setUp() {
		viewModel = TvShowViewModel()
	}

	@Test
	fun getTvShows() {
		val tvShowEntities = viewModel.getTvShows()
		assertNotNull(tvShowEntities)
		assertEquals(13, tvShowEntities.size)
	}
}