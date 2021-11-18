package com.app.themoviedatabase.data.source.remote

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.themoviedatabase.BuildConfig
import com.app.themoviedatabase.api.ApiConfig
import com.app.themoviedatabase.data.source.remote.response.ResultsItem
import com.app.themoviedatabase.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class RemoteDataSource {

	fun getPopularMovie() : LiveData<ApiResponse<List<ResultsItem>>> {
		EspressoIdlingResource.increment()
		val resultMovie = MutableLiveData<ApiResponse<List<ResultsItem>>>()
		CoroutineScope(Dispatchers.IO).launch {
			val client = ApiConfig.getApiService().getPopular("movie", BuildConfig.MOVIEDB_TOKEN, 1)
			try {
				val response = client.awaitResponse()
				if (response.isSuccessful) {
					response.body()?.results?.let {
						resultMovie.postValue(ApiResponse.success(it))
						EspressoIdlingResource.decrement()
					}
				} else {
					Log.d(TAG, "onResponse: ${response.message()}")
				}
			} catch (e: Exception) {
				Log.d(TAG, "Exception: ${e.message}")
			}
		}
		return resultMovie
	}

	fun getPopularTvShow() : LiveData<ApiResponse<List<ResultsItem>>> {
		EspressoIdlingResource.increment()
		val resultTvShow = MutableLiveData<ApiResponse<List<ResultsItem>>>()
		CoroutineScope(Dispatchers.IO).launch {
			val client = ApiConfig.getApiService().getPopular("tv", BuildConfig.MOVIEDB_TOKEN, 1)
			try {
				val response = client.awaitResponse()
				if (response.isSuccessful) {
					response.body()?.results?.let {
						resultTvShow.postValue(ApiResponse.success(it))
						EspressoIdlingResource.decrement()
					}
				} else {
					Log.d(TAG, "onResponse: ${response.message()}")
				}
			} catch (e: Exception) {
				Log.d(TAG, "Exception: ${e.message}")
			}
		}
		return resultTvShow
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