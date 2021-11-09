package com.app.themoviedatabase.ui.detail.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.app.themoviedatabase.BuildConfig
import com.app.themoviedatabase.R
import com.app.themoviedatabase.data.ViewModelFactory
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
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

		val factory = ViewModelFactory.getInstance(this)
		val viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

		val extras = intent.extras
		if (extras != null) {
			val tvShowId = extras.getInt(EXTRA_TVSHOW)

			activityDetailBinding?.progressBar?.visibility = View.VISIBLE
			activityDetailBinding?.content?.visibility = View.INVISIBLE

			viewModel.setSelectedTvShow(tvShowId)
			viewModel.getTvShow().observe(this, { tvShows ->
				activityDetailBinding?.progressBar?.visibility = View.GONE
				activityDetailBinding?.content?.visibility = View.VISIBLE

				populateTvShow(tvShows)
			})


		}
	}

	private fun populateTvShow(tvShowEntity: TvShowEntity) {
		detailContentBinding?.apply {
			supportActionBar?.title = tvShowEntity.title
			tvDetailTitle.text = tvShowEntity.title
			tvDetailDate.text = tvShowEntity.releaseDate
//			tvDetailDuration.text = tvShowEntity.duration
			tvDetailRate.text = resources.getString(R.string.rating_placeholder, tvShowEntity.score)
			tvDetailDescription.text = tvShowEntity.overview
		}
		activityDetailBinding?.imgPoster?.loadImage("${BuildConfig.BASE_IMAGE_URL}${tvShowEntity.backdropPath}")
	}

	private fun ImageView.loadImage(url: String) {
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