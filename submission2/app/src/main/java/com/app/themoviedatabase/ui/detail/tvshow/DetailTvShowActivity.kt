package com.app.themoviedatabase.ui.detail.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.app.themoviedatabase.R
import com.app.themoviedatabase.data.local.entity.TvShowEntity
import com.app.themoviedatabase.databinding.ActivityDetailBinding
import com.app.themoviedatabase.databinding.ContentDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailTvShowActivity : AppCompatActivity() {

	private var activityDetailBinding: ActivityDetailBinding? = null
	private var detailContentBinding: ContentDetailBinding? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
		detailContentBinding = activityDetailBinding?.detailContent

		setContentView(activityDetailBinding?.root)

		setSupportActionBar(activityDetailBinding?.toolbar)
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
		detailContentBinding?.apply {
			supportActionBar?.title = tvShowEntity.title
			tvDetailTitle.text = tvShowEntity.title
			tvDetailDate.text = tvShowEntity.releaseDate
			tvDetailDuration.text = tvShowEntity.duration
			tvDetailGenre.text = tvShowEntity.genre
			tvDetailRate.text = resources.getString(R.string.rating_placeholder, tvShowEntity.score)
			tvDetailDescription.text = tvShowEntity.overview
		}
		activityDetailBinding?.imgPoster?.loadImage(tvShowEntity.imagePath)
	}

	private fun ImageView.loadImage(url: Int) {
		Glide.with(this.context)
			.load(url)
			.apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
			.centerCrop()
			.into(this)
	}

	companion object {
		const val EXTRA_TVSHOW = "extra_tvshow"
	}
}