package com.app.themoviedatabase.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
import com.dicoding.academies.vo.Resource

interface MovieDbDataSource {

	fun getAllPopularMovies(): LiveData<Resource<PagedList<MovieEntity>>>

	fun getFavouritedMovies(): LiveData<PagedList<MovieEntity>>

	fun getMovieById(movieId: Int): LiveData<MovieEntity>

	fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

	fun getAllPopularTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

	fun getFavouritedTvShows(): LiveData<PagedList<TvShowEntity>>

	fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity>

	fun setFavoriteTvSHow(tvShow: TvShowEntity, state: Boolean)

}