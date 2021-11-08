package com.app.themoviedatabase.api

import com.app.themoviedatabase.BuildConfig
import com.app.themoviedatabase.data.remote.response.PopularMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

	@GET("/movie/popular")
	@Headers("Authorization: token ${BuildConfig.MOVIEDB_TOKEN}")
	fun getPopularMovie(
		@Query("page") page: Int
	): Call<PopularMovieResponse>
}