package com.app.themoviedatabase.data.source.local

import androidx.lifecycle.LiveData
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
	fun getMovies(): LiveData<List<MovieEntity>> = mMovieDbDao.getMovies()

	fun getFavouritedMovies(): LiveData<List<MovieEntity>> = mMovieDbDao.getFavouritedMovie()

	fun getMovieById(movieId: String): LiveData<MovieEntity> = mMovieDbDao.getMovieById(movieId)

	fun insertMovies(movies: List<MovieEntity>) = mMovieDbDao.insertMovies(movies)

	fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
		movie.favourited = newState
		mMovieDbDao.updateMovies(movie)
	}

	/**
	 * TvShows
	 */
	fun getTvShows(): LiveData<List<TvShowEntity>> = mMovieDbDao.getTvShows()

	fun getFavouritedTvShows(): LiveData<List<TvShowEntity>> = mMovieDbDao.getFavouritedTvShows()

	fun getTvShowById(tvShowId: String): LiveData<TvShowEntity> = mMovieDbDao.getTvShowById(tvShowId)

	fun insertTvShows(tvShows: List<TvShowEntity>) = mMovieDbDao.insertTvShow(tvShows)

	fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
		tvShow.favourited = newState
		mMovieDbDao.updateTvShows(tvShow)
	}

}