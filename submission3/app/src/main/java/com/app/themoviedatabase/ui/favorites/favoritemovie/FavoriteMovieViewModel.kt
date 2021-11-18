package com.app.themoviedatabase.ui.favorites.favoritemovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.MovieEntity

class FavoriteMovieViewModel(private val movieDbRepository: MovieDbRepository) : ViewModel() {

	fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> = movieDbRepository.getFavouritedMovies()
}