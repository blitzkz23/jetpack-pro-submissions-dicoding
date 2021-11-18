package com.app.themoviedatabase.api

import com.app.themoviedatabase.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiConfig {
	companion object {
		fun getApiService(): ApiService {
			val httpClient = OkHttpClient.Builder()
				.readTimeout(20, TimeUnit.SECONDS)
				.connectTimeout(20, TimeUnit.SECONDS)

			if (BuildConfig.DEBUG) {
				val loggingInterceptor = HttpLoggingInterceptor()
				loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
				httpClient.addInterceptor(loggingInterceptor)
			} else {
				val loggingInterceptor = HttpLoggingInterceptor()
				loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
				httpClient.addInterceptor(loggingInterceptor)
			}

			val retrofit = Retrofit.Builder()
				.baseUrl("https://api.themoviedb.org/3/")
				.addConverterFactory(GsonConverterFactory.create())
				.client(httpClient.build())
				.build()
			return retrofit.create(ApiService::class.java)


		}
	}
}