package com.app.themoviedatabase.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.app.themoviedatabase.data.source.local.LocalDataSource
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
import com.app.themoviedatabase.data.source.remote.RemoteDataSource
import com.app.themoviedatabase.utils.AppExecutors
import com.app.themoviedatabase.utils.DataDummy
import com.app.themoviedatabase.utils.LiveDataTestUtil
import com.app.themoviedatabase.utils.PagedListUtil
import com.dicoding.academies.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieDbRepositoryTest {

	@get:Rule
	var instantTaskExecutorRule = InstantTaskExecutorRule()

	private val remote = mock(RemoteDataSource::class.java)
	private val local = mock(LocalDataSource::class.java)
	private val appExecutors = mock(AppExecutors::class.java)

	@Mock
	private val movieDbRepository = FakeMovieDbRepository(remote, local, appExecutors)

	private val movieResponses = DataDummy.generateRemoteMovieResponses()
	private val movieId = movieResponses[0].id
	private val tvShowResponses = DataDummy.generateRemoteTvShowResponse()
	private val tvShowId = tvShowResponses[0].id

	@Test
	fun getAllPopularMovies() {
		val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
		`when`(local.getMovies()).thenReturn(dataSourceFactory)
		movieDbRepository.getAllPopularMovies()

		val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
		verify(local).getMovies()
		assertNotNull(movieEntities.data)
		assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
	}

	@Test
	fun getPopularMovieById() {
		val dummyMovie = MutableLiveData<MovieEntity>()
		dummyMovie.value = DataDummy.generateDummyMovies()[0]
		`when`(local.getMovieById(movieId)).thenReturn(dummyMovie)

		val movieEntity = LiveDataTestUtil.getValue(movieDbRepository.getMovieById(movieId))
		verify(local).getMovieById(movieId)
		assertNotNull(movieEntity)
		assertEquals(movieResponses[0].title, movieEntity.title)
	}

	@Test
	fun getFavouritedMovies() {
		val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
		`when`(local.getFavouritedMovies()).thenReturn(dataSourceFactory)
		movieDbRepository.getFavouritedMovies()

		val movieEntities = Resource.success(PagedListUtil.mockPagedList((DataDummy.generateDummyMovies())))
		verify(local).getFavouritedMovies()
		assertNotNull(movieEntities)
		assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
	}

	@Test
	fun getAllPopularTvShows() {
		val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
		`when`(local.getTvShows()).thenReturn(dataSourceFactory)
		movieDbRepository.getAllPopularTvShows()

		val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
		verify(local).getTvShows()
		assertNotNull(tvShowEntities.data)
		assertEquals(movieResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
	}

	@Test
	fun getPopularTvShowById() {
		val dummyTvShow = MutableLiveData<TvShowEntity>()
		dummyTvShow.value = DataDummy.generateDummyTvShows()[0]
		`when`(local.getTvShowById(tvShowId)).thenReturn(dummyTvShow)

		val tvShowEntity = LiveDataTestUtil.getValue(movieDbRepository.getTvShowById(tvShowId))
		verify(local).getTvShowById(tvShowId)
		assertNotNull(tvShowEntity)
		assertEquals(tvShowResponses[0].title, tvShowEntity.title)
	}

	@Test
	fun getFavouritedTvShows() {
		val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
		`when`(local.getFavouritedTvShows()).thenReturn(dataSourceFactory)
		movieDbRepository.getFavouritedTvShows()

		val tvShowEntities = Resource.success(PagedListUtil.mockPagedList((DataDummy.generateDummyTvShows())))
		verify(local).getFavouritedTvShows()
		assertNotNull(tvShowEntities)
		assertEquals(movieResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
	}
}