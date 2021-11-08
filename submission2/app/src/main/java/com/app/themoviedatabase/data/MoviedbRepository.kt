package com.app.themoviedatabase.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.remote.RemoteDataSource
import com.app.themoviedatabase.data.source.remote.response.ResultsItem

class MoviedbRepository private constructor(private val remoteDataSource: RemoteDataSource) :
	MoviedbDataSource {

	override fun getAllPopularMovies(): LiveData<List<MovieEntity>> {
		val popularMovieResults = MutableLiveData<List<MovieEntity>>()
		remoteDataSource.getPopularMovie(object : RemoteDataSource.PopularMovieCallback {
			override fun onPopularMoviesReceived(popularMovieResponses: List<ResultsItem>) {
				val popularMovieList = ArrayList<MovieEntity>()
				for (response in popularMovieResponses) {
					val movie = MovieEntity(
						response.id,
						response.title,
						response.releaseDate,
						response.overview,
						response.voteAverage,
						response.posterPath,
					)
					popularMovieList.add(movie)
				}
				popularMovieResults.postValue(popularMovieList)
			}

			override fun onDataNotAvailable() {
				Log.e(TAG, "onFailure: Data failed to load.")
			}
		})
		return popularMovieResults
	}

	companion object {
		@Volatile
		private var instance: MoviedbRepository? = null
		private const val TAG = "MovieDbRepository"

		fun getInstance(remoteData: RemoteDataSource): MoviedbRepository =
			instance ?: synchronized(this) {
				MoviedbRepository(remoteData).apply { instance = this }
			}
	}

}