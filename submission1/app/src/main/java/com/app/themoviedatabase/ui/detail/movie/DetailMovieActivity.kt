package com.app.themoviedatabase.ui.detail.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.app.themoviedatabase.R
import com.app.themoviedatabase.data.MovieEntity
import com.app.themoviedatabase.databinding.ActivityDetailBinding
import com.app.themoviedatabase.databinding.ContentDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailMovieActivity : AppCompatActivity() {

	private lateinit var activityDetailBinding: ActivityDetailBinding
	private lateinit var detailContentBinding: ContentDetailBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
		detailContentBinding = activityDetailBinding.detailContent

		setContentView(activityDetailBinding.root)

		setSupportActionBar(activityDetailBinding.toolbar)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)

		val viewModel = ViewModelProvider(
			this,
			ViewModelProvider.NewInstanceFactory()
		)[DetailMovieViewModel::class.java]

		val extras = intent.extras
		if (extras != null) {
			val movieId = extras.getString(EXTRA_MOVIE)
			if (movieId != null) {
				viewModel.setSelectedMovie(movieId)
				val movies = viewModel.getMovie()
				populateMovies(movies)
			}
		}

	}

	private fun populateMovies(movieEntity: MovieEntity) {
		with(detailContentBinding) {
			supportActionBar?.title = movieEntity.title
			tvDetailTitle.text = movieEntity.title
			tvDetailDate.text = movieEntity.releaseDate
			tvDetailDuration.text = movieEntity.duration
			tvDetailGenre.text = movieEntity.genre
			tvDetailRate.text = resources.getString(R.string.rating_placeholder, movieEntity.score)
			tvDetailDescription.text = movieEntity.overview
		}
		Glide.with(this)
			.load(movieEntity.imagePath)
			.apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
			.into(activityDetailBinding.imgPoster)
	}

	companion object {
		const val EXTRA_MOVIE = "extra_movie"
	}
}