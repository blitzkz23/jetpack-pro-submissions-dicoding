package com.app.themoviedatabase.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity

class DetailTvShowViewModel(private val movieDbRepository: MovieDbRepository) : ViewModel() {
	private var tvShowId = MutableLiveData<Int>()

	fun setSelectedTvShow(tvShowId: Int) {
		this.tvShowId.value = tvShowId
	}

	var tvShowDetail : LiveData<TvShowEntity> = Transformations.switchMap(tvShowId) { mTvShowId ->
		movieDbRepository.getTvShowById(mTvShowId)
	}

	fun setFavorited() {
		val tvShowEntity = tvShowDetail.value
		if (tvShowEntity != null) {
			val newState = !tvShowEntity.favourited
			movieDbRepository.setFavoriteTvSHow(tvShowEntity, newState)
		}
	}
}