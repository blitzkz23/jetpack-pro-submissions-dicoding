package com.app.themoviedatabase.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.app.themoviedatabase.data.source.local.LocalDataSource
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
import com.app.themoviedatabase.data.source.remote.ApiResponse
import com.app.themoviedatabase.data.source.remote.RemoteDataSource
import com.app.themoviedatabase.data.source.remote.response.ResultsItem
import com.app.themoviedatabase.utils.AppExecutors
import com.dicoding.academies.vo.Resource

class FakeMovieDbRepository constructor(
	private val remoteDataSource: RemoteDataSource,
	private val localDataSource: LocalDataSource,
	private val appExecutors: AppExecutors
) :
	MovieDbDataSource {

	override fun getAllPopularMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
		return object :
			NetworkBoundResource<PagedList<MovieEntity>, List<ResultsItem>>(appExecutors) {
			override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
				val config = PagedList.Config.Builder()
					.setEnablePlaceholders(false)
					.setInitialLoadSizeHint(10)
					.setPageSize(10)
					.build()
				return LivePagedListBuilder(localDataSource.getMovies(), config).build()
			}

			override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
				data == null || data.isEmpty()

			override fun createCall(): LiveData<ApiResponse<List<ResultsItem>>> =
				remoteDataSource.getPopularMovie()

			override fun saveCallResult(data: List<ResultsItem>) {
				val popularMovieList = ArrayList<MovieEntity>()
				for (response in data) {
					val movie = MovieEntity(
						response.id,
						response.title,
						response.releaseDate,
						response.overview,
						response.originalLanguage,
						response.voteAverage,
						response.popularity,
						response.posterPath,
						response.backdropPath,
					)
					popularMovieList.add(movie)
				}
				localDataSource.insertMovies(popularMovieList)
			}
		}.asLiveData()
	}

	override fun getFavouritedMovies(): LiveData<PagedList<MovieEntity>> {
		val config = PagedList.Config.Builder()
			.setEnablePlaceholders(false)
			.setInitialLoadSizeHint(4)
			.setPageSize(4)
			.build()
		return LivePagedListBuilder(localDataSource.getFavouritedMovies(), config).build()
	}

	override fun getMovieById(movieId: Int): LiveData<MovieEntity> =
		localDataSource.getMovieById(movieId)

	override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
		appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movie, state) }
	}

	override fun getAllPopularTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
		return object :
			NetworkBoundResource<PagedList<TvShowEntity>, List<ResultsItem>>(appExecutors) {
			override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
				val config = PagedList.Config.Builder()
					.setEnablePlaceholders(false)
					.setInitialLoadSizeHint(10)
					.setPageSize(10)
					.build()
				return LivePagedListBuilder(localDataSource.getTvShows(), config).build()
			}

			override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
				data == null || data.isEmpty()

			override fun createCall(): LiveData<ApiResponse<List<ResultsItem>>> =
				remoteDataSource.getPopularTvShow()

			override fun saveCallResult(data: List<ResultsItem>) {
				val popularTvShowList = ArrayList<TvShowEntity>()
				for (response in data) {
					val tvShows = TvShowEntity(
						response.id,
						response.title,
						response.releaseDate,
						response.overview,
						response.originalLanguage,
						response.voteAverage,
						response.popularity,
						response.posterPath,
						response.backdropPath,
					)
					popularTvShowList.add(tvShows)
				}
				localDataSource.insertTvShows(popularTvShowList)
			}
		}.asLiveData()
	}

	override fun getFavouritedTvShows(): LiveData<PagedList<TvShowEntity>> {
		val config = PagedList.Config.Builder()
			.setEnablePlaceholders(false)
			.setInitialLoadSizeHint(4)
			.setPageSize(4)
			.build()
		return LivePagedListBuilder(localDataSource.getFavouritedTvShows(), config).build()
	}

	override fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity> =
		localDataSource.getTvShowById(tvShowId)

	override fun setFavoriteTvSHow(tvShow: TvShowEntity, state: Boolean) =
		appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShow, state) }

}