//package com.app.themoviedatabase.data
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import com.app.themoviedatabase.data.source.remote.RemoteDataSource
//import com.app.themoviedatabase.utils.DataDummy
//import com.app.themoviedatabase.utils.LiveDataTestUtil
//import com.nhaarman.mockitokotlin2.any
//import com.nhaarman.mockitokotlin2.verify
//import org.junit.Assert.assertEquals
//import org.junit.Assert.assertNotNull
//import org.junit.Rule
//import org.junit.Test
//import org.mockito.Mock
//import org.mockito.Mockito.doAnswer
//import org.mockito.Mockito.mock
//
//class MovieDbRepositoryTest {
//
//	@get:Rule
//	var instantTaskExecutorRule = InstantTaskExecutorRule()
//
//	private val remote = mock(RemoteDataSource::class.java)
//
//	@Mock
//	private val movieDbRepository = FakeMovieDbRepository(remote)
//
//	private val movieResponses = DataDummy.generateRemoteMovieResponses()
//	private val movieId = movieResponses[0].id
//	private val tvShowResponses = DataDummy.generateRemoteTvShowResponse()
//	private val tvShowId = tvShowResponses[0].id
//
//	@Test
//	fun getAllPopularMovies() {
//		doAnswer { invocation ->
//			(invocation.arguments[0] as RemoteDataSource.PopularCallback)
//				.onPopularDataReceived(movieResponses)
//			null
//		}.`when`(remote).getPopularMovie(any())
//		val movieEntities = LiveDataTestUtil.getValue(movieDbRepository.getAllPopularMovies())
//		verify(remote).getPopularMovie(any())
//		assertNotNull(movieEntities)
//		assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
//	}
//
//	@Test
//	fun getPopularMovieById() {
//		doAnswer { invocation ->
//			(invocation.arguments[0] as RemoteDataSource.PopularCallback)
//				.onPopularDataReceived(movieResponses)
//			null
//		}.`when`(remote).getPopularMovie(any())
//
//		val movieEntity = LiveDataTestUtil.getValue(movieDbRepository.getPopularMovieById(movieId))
//		verify(remote).getPopularMovie(any())
//		assertNotNull(movieEntity)
//	}
//
//	@Test
//	fun getAllPopularTvShows() {
//		doAnswer { invocation ->
//			(invocation.arguments[0] as RemoteDataSource.PopularCallback)
//				.onPopularDataReceived(tvShowResponses)
//			null
//		}.`when`(remote).getPopularTvShow(any())
//		val tvShowEntities = LiveDataTestUtil.getValue(movieDbRepository.getAllPopularTvShows())
//		verify(remote).getPopularTvShow(any())
//		assertNotNull(tvShowEntities)
//		assertEquals(tvShowResponses.size.toLong(), tvShowEntities.size.toLong())
//	}
//
//	@Test
//	fun getPopularTvShowById() {
//		doAnswer { invocation ->
//			(invocation.arguments[0] as RemoteDataSource.PopularCallback)
//				.onPopularDataReceived(tvShowResponses)
//			null
//		}.`when`(remote).getPopularTvShow(any())
//
//		val tvShowEntity = LiveDataTestUtil.getValue(movieDbRepository.getPopularTvShowById(tvShowId))
//		verify(remote).getPopularTvShow(any())
//		assertNotNull(tvShowEntity)
//	}
//}