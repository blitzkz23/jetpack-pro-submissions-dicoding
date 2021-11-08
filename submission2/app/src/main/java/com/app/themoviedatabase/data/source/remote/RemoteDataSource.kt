package com.app.themoviedatabase.data.source.remote

import android.content.ContentValues.TAG
import android.util.Log
import com.app.themoviedatabase.api.ApiConfig
import com.app.themoviedatabase.data.source.remote.response.ResultsItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class RemoteDataSource {

	fun getPopularMovie(callback: PopularMovieCallback) {
		CoroutineScope(Dispatchers.IO).launch {
			val client = ApiConfig.getApiService().getPopularMovie(1)
			try {
				val response = client.awaitResponse()
				if (response.isSuccessful) {
					response.body()?.results?.let {
						callback.onPopularMoviesReceived(it)
					}
				} else {
					Log.d(TAG, "onResponse: ${response.message()}")
				}
			} catch (e: Exception) {
				callback.onDataNotAvailable()
			}
		}
	}

	interface PopularMovieCallback {
		fun onPopularMoviesReceived(popularMovieResponses: List<ResultsItem>)
		fun onDataNotAvailable()
	}

	companion object {
		@Volatile
		private var instance: RemoteDataSource ?= null

		fun getInstance(): RemoteDataSource =
			instance ?: synchronized(this) {
				RemoteDataSource().apply { instance = this }
			}
	}

}