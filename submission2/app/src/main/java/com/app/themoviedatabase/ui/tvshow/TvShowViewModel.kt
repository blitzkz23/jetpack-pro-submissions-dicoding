package com.app.themoviedatabase.ui.tvshow

import androidx.lifecycle.ViewModel
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
import com.app.themoviedatabase.utils.DataDummy

class TvShowViewModel(private val movieDbRepository: MovieDbRepository) : ViewModel() {

	fun getTvShows(): List<TvShowEntity> = DataDummy.generateDummyTvShows()
}