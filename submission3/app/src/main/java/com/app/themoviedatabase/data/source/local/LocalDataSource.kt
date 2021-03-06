package com.app.themoviedatabase.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
import com.app.themoviedatabase.data.source.local.room.MovieDbDao

class LocalDataSource private constructor(private val mMovieDbDao: MovieDbDao){
	companion object {
		private var INSTANCE: LocalDataSource? = null

		fun getInstance(movieDbDao: MovieDbDao): LocalDataSource =
			INSTANCE ?: LocalDataSource(movieDbDao)
	}

	/**
	 * Movie
	 */
	fun getMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDbDao.getMovies()

	fun getFavouritedMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDbDao.getFavouritedMovie()

	fun getMovieById(movieId: Int): LiveData<MovieEntity> = mMovieDbDao.getMovieById(movieId)

	fun insertMovies(movies: List<MovieEntity>) = mMovieDbDao.insertMovies(movies)

	fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
		movie.favourited = newState
		mMovieDbDao.updateMovies(movie)
	}

	/**
	 * TvShows
	 */
	fun getTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieDbDao.getTvShows()

	fun getFavouritedTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieDbDao.getFavouritedTvShows()

	fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity> = mMovieDbDao.getTvShowById(tvShowId)

	fun insertTvShows(tvShows: List<TvShowEntity>) = mMovieDbDao.insertTvShow(tvShows)

	fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
		tvShow.favourited = newState
		mMovieDbDao.updateTvShows(tvShow)
	}

}