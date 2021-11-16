package com.app.themoviedatabase.data

import androidx.lifecycle.LiveData
import com.app.themoviedatabase.data.source.local.LocalDataSource
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
import com.app.themoviedatabase.data.source.remote.ApiResponse
import com.app.themoviedatabase.data.source.remote.RemoteDataSource
import com.app.themoviedatabase.data.source.remote.response.ResultsItem
import com.app.themoviedatabase.utils.AppExecutors
import com.dicoding.academies.vo.Resource

class MovieDbRepository private constructor(
	private val remoteDataSource: RemoteDataSource,
	private val localDataSource: LocalDataSource,
	private val appExecutors: AppExecutors
) :
	MovieDbDataSource {

	override fun getAllPopularMovies(): LiveData<Resource<List<MovieEntity>>> {
		return object : NetworkBoundResource<List<MovieEntity>, List<ResultsItem>>(appExecutors) {
			override fun loadFromDB(): LiveData<List<MovieEntity>> =
				localDataSource.getMovies()

			override fun shouldFetch(data: List<MovieEntity>?): Boolean =
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

	override fun getFavouritedMovies(): LiveData<List<MovieEntity>> =
		localDataSource.getFavouritedMovies()

	override fun getMovieById(movieId: String): LiveData<MovieEntity> =
		localDataSource.getMovieById(movieId)

	override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
		appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movie, state) }
	}

	override fun getAllPopularTvShows(): LiveData<Resource<List<TvShowEntity>>> {
		return object : NetworkBoundResource<List<TvShowEntity>, List<ResultsItem>>(appExecutors) {
			override fun loadFromDB(): LiveData<List<TvShowEntity>> =
				localDataSource.getTvShows()

			override fun shouldFetch(data: List<TvShowEntity>?): Boolean =
				data == null || data.isEmpty()

			override fun createCall(): LiveData<ApiResponse<List<ResultsItem>>> =
				remoteDataSource.getPopularMovie()

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

	override fun getFavouritedTvShows(): LiveData<List<TvShowEntity>> =
		localDataSource.getFavouritedTvShows()

	override fun getTvShowById(tvShowId: String): LiveData<TvShowEntity> =
		localDataSource.getTvShowById(tvShowId)

	override fun setFavoriteTvSHow(tvShow: TvShowEntity, state: Boolean) =
		appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShow, state) }

	companion object {
		@Volatile
		private var instance: MovieDbRepository? = null
		private const val TAG = "MovieDbRepository"

		fun getInstance(
			remoteData: RemoteDataSource,
			locaData: LocalDataSource,
			appExecutors: AppExecutors
		): MovieDbRepository =
			instance ?: synchronized(this) {
				MovieDbRepository(remoteData, locaData, appExecutors).apply { instance = this }
			}
	}

}