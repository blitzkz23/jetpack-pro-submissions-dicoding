package com.app.themoviedatabase.ui.detail.movie

import com.app.themoviedatabase.ui.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class DetailMovieViewModelTest {

	private lateinit var viewModel: DetailMovieViewModel
	private val dummyMovies = DataDummy.generateDummyMovies()[0]
	private val movieId = dummyMovies.movieId

	@Before
	fun setUp() {
		viewModel = DetailMovieViewModel()
		viewModel.setSelectedMovie(movieId)
	}

	@Test
	fun getMovie() {
		viewModel.setSelectedMovie(movieId)
		val movieEntities = viewModel.getMovie()
		assertNotNull(movieEntities)
		assertEquals(dummyMovies.movieId, movieEntities.movieId)
		assertEquals(dummyMovies.title, movieEntities.title)
		assertEquals(dummyMovies.releaseDate, movieEntities.releaseDate)
		assertEquals(dummyMovies.score, movieEntities.score)
		assertEquals(dummyMovies.genre, movieEntities.genre)
		assertEquals(dummyMovies.duration, movieEntities.duration)
		assertEquals(dummyMovies.overview, movieEntities.overview)
	}
}