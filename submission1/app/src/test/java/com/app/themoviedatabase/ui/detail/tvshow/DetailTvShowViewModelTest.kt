package com.app.themoviedatabase.ui.detail.tvshow

import com.app.themoviedatabase.ui.detail.movie.DetailMovieViewModel
import com.app.themoviedatabase.ui.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class DetailTvShowViewModelTest {

	private lateinit var viewModel: DetailMovieViewModel
	private val dummyMovies = DataDummy.generateDummyMovies()[0]
	private val tvShowId = dummyMovies.movieId

	@Before
	fun setUp() {
		viewModel = DetailMovieViewModel()
		viewModel.setSelectedMovie(tvShowId)
	}

	@Test
	fun getTvShow() {
		viewModel.setSelectedMovie(tvShowId)
		val tvShowEntities = viewModel.getMovie()
		assertNotNull(tvShowEntities)
		assertEquals(dummyMovies.movieId, tvShowEntities.movieId)
		assertEquals(dummyMovies.title, tvShowEntities.title)
		assertEquals(dummyMovies.releaseDate, tvShowEntities.releaseDate)
		assertEquals(dummyMovies.score, tvShowEntities.score)
		assertEquals(dummyMovies.genre, tvShowEntities.genre)
		assertEquals(dummyMovies.duration, tvShowEntities.duration)
		assertEquals(dummyMovies.overview, tvShowEntities.overview)
	}
}