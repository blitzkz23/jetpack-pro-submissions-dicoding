package com.app.themoviedatabase.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity


@Dao
interface MovieDbDao {

	/**
	 * Query for movie
	 */
	@Query("SELECT * FROM movieentities")
	fun getMovies(): DataSource.Factory<Int, MovieEntity>

	@Query("SELECT * FROM movieentities WHERE favourited = 1")
	fun getFavouritedMovie(): LiveData<List<MovieEntity>>

	@Query("SELECT * FROM movieentities WHERE movieId = :movieId")
	fun getMovieById(movieId: Int): LiveData<MovieEntity>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertMovies(movies: List<MovieEntity>)

	@Update
	fun updateMovies(movies: MovieEntity)

	/**
	 * Query for tv show
	 */
	@Query("SELECT * FROM tvshowentities")
	fun getTvShows(): DataSource.Factory<Int, TvShowEntity>

	@Query("SELECT * FROM tvshowentities WHERE favourited = 1")
	fun getFavouritedTvShows(): LiveData<List<TvShowEntity>>

	@Query("SELECT * FROM tvshowentities WHERE tvShowId = :tvShowId")
	fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertTvShow(tvShows: List<TvShowEntity>)

	@Update
	fun updateTvShows(tvShows: TvShowEntity)

}