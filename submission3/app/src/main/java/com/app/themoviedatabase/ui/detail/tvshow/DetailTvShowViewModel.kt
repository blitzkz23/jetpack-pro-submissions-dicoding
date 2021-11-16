package com.app.themoviedatabase.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity

class DetailTvShowViewModel(private val movieDbRepository: MovieDbRepository) : ViewModel() {
	private var tvShowId: Int = 0

	fun setSelectedTvShow(tvShowId: Int) {
		this.tvShowId = tvShowId
	}

	fun getTvShow(): LiveData<TvShowEntity> = movieDbRepository.getPopularTvShowById(tvShowId)
}