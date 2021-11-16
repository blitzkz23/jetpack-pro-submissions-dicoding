package com.app.themoviedatabase.data

import androidx.lifecycle.LiveData
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity

interface MovieDbDataSource {

	fun getAllPopularMovies(): LiveData<List<MovieEntity>>

	fun getPopularMovieById(movieId: Int): LiveData<MovieEntity>

	fun getAllPopularTvShows(): LiveData<List<TvShowEntity>>

	fun getPopularTvShowById(tvShowId: Int): LiveData<TvShowEntity>
}