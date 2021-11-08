package com.app.themoviedatabase.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.remote.RemoteDataSource
import com.app.themoviedatabase.data.source.remote.response.ResultsItem

class MoviedbRepository private constructor(private  val remoteDataSource: RemoteDataSource) : MoviedbDataSource{

	override fun getAllPopularMovies(): LiveData<List<ResultsItem>> {
		val popularMovieResults = MutableLiveData<List<ResultsItem>>()
		remoteDataSource.getPopularMovie(object: RemoteDataSource.PopularMovieCallback {
			override fun onPopularMoviesReceived(popularMovieResponses: List<ResultsItem>) {
				val popularMovieList = ArrayList<ResultsItem>()
				for (response in popularMovieResponses) {
					val movie = MovieEntity(
						response.id,
						response.title,

					)
				}
			}

			override fun onDataNotAvailable() {
				TODO("Not yet implemented")
			}
		})
	}

	companion object {
		@Volatile
		private var instance: MoviedbRepository? = null

		fun getInstance(remoteData: RemoteDataSource): MoviedbRepository {
			instance ?: synchronized(this) {
				MoviedbRepository(remoteData).apply { instance = this }
			}
		}
	}

}