package com.app.themoviedatabase.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.app.themoviedatabase.data.MovieDbRepository
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.dicoding.academies.vo.Resource

class MovieViewModel(private val movieDbRepository: MovieDbRepository) : ViewModel() {

	fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = movieDbRepository.getAllPopularMovies()
}