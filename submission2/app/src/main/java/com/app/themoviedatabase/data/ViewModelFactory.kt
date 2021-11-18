package com.app.themoviedatabase.data

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.themoviedatabase.di.Injection
import com.app.themoviedatabase.ui.detail.movie.DetailMovieViewModel
import com.app.themoviedatabase.ui.detail.tvshow.DetailTvShowViewModel
import com.app.themoviedatabase.ui.movie.MovieViewModel
import com.app.themoviedatabase.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mMovieDbRepository: MovieDbRepository) :
	ViewModelProvider.NewInstanceFactory() {

	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		return when {
			modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
				MovieViewModel(mMovieDbRepository) as T
			}
			modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
				TvShowViewModel(mMovieDbRepository) as T
			}
			modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
				DetailMovieViewModel(mMovieDbRepository) as T
			}
			modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
				DetailTvShowViewModel(mMovieDbRepository) as T
			}
			else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
		}
	}

	companion object {
		@Volatile
		private var instance: ViewModelFactory ? = null

		fun getInstance(context: Context): ViewModelFactory =
			instance ?: synchronized(this) {
				ViewModelFactory(Injection.provideRepository(context)).apply {
					instance = this
				}
			}
	}
}