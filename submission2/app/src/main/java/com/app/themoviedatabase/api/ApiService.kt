package com.app.themoviedatabase.api

import com.app.themoviedatabase.data.source.remote.response.PopularMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

	@GET("/movie/popular")
	fun getPopularMovie(
		@Query("api_key") apiKey: String,
		@Query("page") page: Int
	): Call<PopularMovieResponse>
}