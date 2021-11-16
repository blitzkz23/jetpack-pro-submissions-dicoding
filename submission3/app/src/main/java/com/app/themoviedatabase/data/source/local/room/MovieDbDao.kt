package com.app.themoviedatabase.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity

interface MovieDbDao {

	/**
	 * Query for movie
	 */
	@Query("SELECT * FROM movieentities")
	fun getMovies(): LiveData<List<MovieEntity>>

	@Query("SELECT * FROM movieentities WHERE favourited = 1")
	fun getFavouritedMovie(): LiveData<List<MovieEntity>>

	@Query("SELECT * FROM movieentities WHERE movieId = :movieId")
	fun getMovieById(movieId: String): LiveData<MovieEntity>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertMovies(movies: List<MovieEntity>)

	@Update
	fun updateMovies(movies: MovieEntity)

	/**
	 * Query for tv show
	 */
	@Query("SELECT * FROM tvshowentities")
	fun getTvShows(): LiveData<List<TvShowEntity>>

	@Query("SELECT * FROM tvshowentities WHERE favourited = 1")
	fun getFavouritedTvShows(): LiveData<List<TvShowEntity>>

	@Query("SELECT * FROM tvshowentities WHERE tvShowId = :tvShowId")
	fun getTvShowsById(tvShowId: String): LiveData<TvShowEntity>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertTvShows(tvShows: List<TvShowEntity>)

	@Update
	fun updateTvShows(tvShows: TvShowEntity)

}