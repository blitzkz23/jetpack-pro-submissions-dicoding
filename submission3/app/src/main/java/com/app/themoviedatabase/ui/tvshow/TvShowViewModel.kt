package com.app.themoviedatabase.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
import com.dicoding.academies.vo.Resource

class TvShowViewModel(private val movieDbRepository: MovieDbRepository) : ViewModel() {

	fun getTvShows(): LiveData<Resource<List<TvShowEntity>>> = movieDbRepository.getAllPopularTvShows()
}