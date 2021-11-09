package com.app.themoviedatabase.ui.detail.movie

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.app.themoviedatabase.BuildConfig
import com.app.themoviedatabase.R
import com.app.themoviedatabase.data.ViewModelFactory
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.databinding.ActivityDetailBinding
import com.app.themoviedatabase.databinding.ContentDetailBinding
import com.app.themoviedatabase.ui.movie.MovieViewModel
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

		val factory = ViewModelFactory.getInstance(this)
		val viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

		val extras = intent.extras
		if (extras != null) {
			val movieId = extras.getInt(EXTRA_MOVIE)

			activityDetailBinding?.progressBar?.visibility = View.VISIBLE
			activityDetailBinding?.content?.visibility = View.INVISIBLE

			viewModel.setSelectedMovie(movieId)
			viewModel.getMovie().observe(this, { movies ->
				activityDetailBinding?.progressBar?.visibility = View.GONE
				activityDetailBinding?.content?.visibility = View.VISIBLE

				populateMovies(movies)
			})
		}
	}

	private fun populateMovies(movieEntity: MovieEntity) {
		detailContentBinding?.apply {
			supportActionBar?.title = movieEntity.title
			tvDetailTitle.text = movieEntity.title
			tvDetailDate.text = movieEntity.releaseDate
//			tvDetailDuration.text = movieEntity.duration
//			tvDetailGenre.text = movieEntity.genre
			tvDetailRate.text = resources.getString(R.string.rating_placeholder, movieEntity.score)
			tvDetailDescription.text = movieEntity.overview
		}
		activityDetailBinding?.imgPoster?.loadImage("${BuildConfig.BASE_IMAGE_URL}${movieEntity.backdropPath}")
	}

	private fun ImageView.loadImage(url: String?) {
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