package com.app.themoviedatabase.ui.favorites.favoritetvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity

class FavoriteTvShowViewModel(private val movieDbRepository: MovieDbRepository) : ViewModel() {

	fun getFavouritedTvShows(): LiveData<PagedList<TvShowEntity>> = movieDbRepository.getFavouritedTvShows()
}