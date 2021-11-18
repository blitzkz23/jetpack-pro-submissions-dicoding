package com.app.themoviedatabase.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
import com.app.themoviedatabase.data.source.remote.RemoteDataSource
import com.app.themoviedatabase.data.source.remote.response.ResultsItem

class FakeMovieDbRepository(private val remoteDataSource: RemoteDataSource) :
	MovieDbDataSource {

	override fun getAllPopularMovies(): LiveData<List<MovieEntity>> {
		val popularMovieResults = MutableLiveData<List<MovieEntity>>()
		remoteDataSource.getPopularMovie(object : RemoteDataSource.PopularCallback {
			override fun onPopularDataReceived(popularResponses: List<ResultsItem>) {
				val popularMovieList = ArrayList<MovieEntity>()
				for (response in popularResponses) {
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
				popularMovieResults.postValue(popularMovieList)
			}

			override fun onDataNotAvailable() {
				Log.e(TAG, "onFailure: Movie failed to load.")
			}
		})
		return popularMovieResults
	}

	override fun getPopularMovieById(movieId: Int): LiveData<MovieEntity> {
		val popularMovieResults = MutableLiveData<MovieEntity>()
		remoteDataSource.getPopularMovie(object : RemoteDataSource.PopularCallback {
			override fun onPopularDataReceived(popularResponses: List<ResultsItem>) {
				lateinit var movie: MovieEntity
				for (response in popularResponses) {
					if (response.id == movieId) {
						movie = MovieEntity(
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
					}
				}
				popularMovieResults.postValue(movie)
			}

			override fun onDataNotAvailable() {
				Log.e(TAG, "onFailure: Movie failed to load.")
			}
		})
		return popularMovieResults
	}

	override fun getAllPopularTvShows(): LiveData<List<TvShowEntity>> {
		val popularTvShowResults = MutableLiveData<List<TvShowEntity>>()
		remoteDataSource.getPopularTvShow(object : RemoteDataSource.PopularCallback {
			override fun onPopularDataReceived(popularResponses: List<ResultsItem>) {
				val popularTvShowList = ArrayList<TvShowEntity>()
				for (response in popularResponses) {
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
				popularTvShowResults.postValue(popularTvShowList)
			}

			override fun onDataNotAvailable() {
				Log.e(TAG, "onFailure: TvShow failed to load.")
			}
		})
		return popularTvShowResults
	}

	override fun getPopularTvShowById(tvShowId: Int): LiveData<TvShowEntity> {
		val popularTvShowResult = MutableLiveData<TvShowEntity>()
		remoteDataSource.getPopularTvShow(object : RemoteDataSource.PopularCallback {
			override fun onPopularDataReceived(popularResponses: List<ResultsItem>) {
				lateinit var tvShow: TvShowEntity
				for (response in popularResponses) {
					if (response.id == tvShowId) {
						tvShow = TvShowEntity(
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
					}
				}
				popularTvShowResult.postValue(tvShow)
			}

			override fun onDataNotAvailable() {
				Log.e(TAG, "onFailure: TvShow failed to load.")
			}
		})
		return popularTvShowResult
	}


	companion object {
		private const val TAG = "MovieDbRepository"
	}

}