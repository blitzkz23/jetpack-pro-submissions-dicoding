package com.app.themoviedatabase.data

import androidx.lifecycle.LiveData
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
import com.dicoding.academies.vo.Resource

interface MovieDbDataSource {

	fun getAllPopularMovies(): LiveData<Resource<List<MovieEntity>>>

	fun getFavouritedMovies(): LiveData<List<MovieEntity>>

	fun getMovieById(movieId: Int): LiveData<MovieEntity>

	fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

//	fun getPopularMovieById(movieId: Int): LiveData<MovieEntity>

	fun getAllPopularTvShows(): LiveData<Resource<List<TvShowEntity>>>

	fun getFavouritedTvShows(): LiveData<List<TvShowEntity>>

	fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity>

	fun setFavoriteTvSHow(tvShow: TvShowEntity, state: Boolean)
//	fun getPopularTvShowById(tvShowId: Int): LiveData<TvShowEntity>
}