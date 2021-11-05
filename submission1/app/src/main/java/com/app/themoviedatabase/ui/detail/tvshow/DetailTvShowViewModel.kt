package com.app.themoviedatabase.ui.detail.tvshow

import androidx.lifecycle.ViewModel
import com.app.themoviedatabase.data.TvShowEntity
import com.app.themoviedatabase.ui.utils.DataDummy

class DetailTvShowViewModel : ViewModel() {
	private lateinit var tvShowId: String

	fun setSelectedTvShow(tvShowId: String) {
		this.tvShowId = tvShowId
	}

	fun getTvShow(): TvShowEntity {
		lateinit var tvShow: TvShowEntity
		val tvShowEntities = DataDummy.generateDummyTvShows()
		for (tvShowEntity in tvShowEntities) {
			if (tvShowEntity.tvShowId == tvShowId) {
				tvShow = tvShowEntity
				break
			}
		}
		return tvShow
	}
}