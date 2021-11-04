package com.app.themoviedatabase.ui.detail.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.app.themoviedatabase.R
import com.app.themoviedatabase.data.TvShowEntity
import com.app.themoviedatabase.databinding.ActivityDetailBinding
import com.app.themoviedatabase.databinding.ContentDetailBinding
import com.app.themoviedatabase.ui.detail.movie.DetailMovieViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailTvShowActivity : AppCompatActivity() {

	private lateinit var activityDetailBinding: ActivityDetailBinding
	private lateinit var detailContentBinding: ContentDetailBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
		detailContentBinding = activityDetailBinding.detailContent

		setContentView(activityDetailBinding.root)

		setSupportActionBar(activityDetailBinding.toolbar)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)

		val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailTvShowViewModel::class.java]

		val extras = intent.extras
		if (extras != null) {
			val tvShowId = extras.getString(EXTRA_TVSHOW)
			if (tvShowId != null) {
				viewModel.setSelectedTvShow(tvShowId)
				val tvShows = viewModel.getTvShow()
				populateTvShow(tvShows as TvShowEntity)
			}
		}
	}

	private fun populateTvShow(tvShowEntity: TvShowEntity) {
		with(detailContentBinding) {
			supportActionBar?.title = tvShowEntity.title
			tvDetailTitle.text = tvShowEntity.title
			tvDetailDate.text = tvShowEntity.releaseDate
			tvDetailDuration.text = tvShowEntity.duration
			tvDetailGenre.text = tvShowEntity.genre
			tvDetailRate.text = resources.getString(R.string.rating_placeholder, tvShowEntity.score)
			tvDetailDescription.text = tvShowEntity.overview
		}
		Glide.with(this)
			.load(tvShowEntity.imagePath)
			.apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
			.into(activityDetailBinding.imgPoster)
	}

	companion object {
		const val EXTRA_TVSHOW = "extra_tvshow"
	}
}