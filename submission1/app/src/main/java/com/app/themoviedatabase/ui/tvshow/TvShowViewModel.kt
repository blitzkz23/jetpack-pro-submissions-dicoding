package com.app.themoviedatabase.ui.tvshow

import androidx.lifecycle.ViewModel
import com.app.themoviedatabase.data.TvShowEntity
import com.app.themoviedatabase.ui.utils.DataDummy

class TvShowViewModel : ViewModel() {

	fun getTvShows(): List<TvShowEntity> = DataDummy.generateDummyTvShows()
}