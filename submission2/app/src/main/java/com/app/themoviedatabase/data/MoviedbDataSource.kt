package com.app.themoviedatabase.data

import androidx.lifecycle.LiveData
import com.app.themoviedatabase.data.source.remote.response.ResultsItem

interface MoviedbDataSource {

	fun getAllPopularMovies(): LiveData<List<ResultsItem>>
}