package com.app.themoviedatabase.api

import com.app.themoviedatabase.data.source.remote.response.PopularMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

	@GET("{urlType}/popular")
	fun getPopular(
		@Path("urlType") urlType: String,
		@Query("api_key") apiKey: String,
		@Query("page") page: Int
	): Call<PopularMovieResponse>
}