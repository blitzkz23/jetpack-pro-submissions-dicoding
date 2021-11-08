package com.app.themoviedatabase.ui.detail.movie

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.app.themoviedatabase.R
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.databinding.ActivityDetailBinding
import com.app.themoviedatabase.databinding.ContentDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailMovieActivity : AppCompatActivity() {

	private var activityDetailBinding: ActivityDetailBinding? = null
	private var detailContentBinding: ContentDetailBinding? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
		detailContentBinding = activityDetailBinding?.detailContent

		setContentView(activityDetailBinding?.root)

		setSupportActionBar(activityDetailBinding?.toolbar)
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
		detailContentBinding?.apply {
			supportActionBar?.title = movieEntity.title
			tvDetailTitle.text = movieEntity.title
			tvDetailDate.text = movieEntity.releaseDate
			tvDetailDuration.text = movieEntity.duration
			tvDetailGenre.text = movieEntity.genre
			tvDetailRate.text = resources.getString(R.string.rating_placeholder, movieEntity.score)
			tvDetailDescription.text = movieEntity.overview
		}
		activityDetailBinding?.imgPoster?.loadImage(movieEntity.imagePath)
	}

	private fun ImageView.loadImage(url: Int) {
		Glide.with(this.context)
			.load(url)
			.apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
			.centerCrop()
			.into(this)
	}

	companion object {
		const val EXTRA_MOVIE = "extra_movie"
	}
}