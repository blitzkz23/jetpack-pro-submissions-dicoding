package com.app.themoviedatabase.ui.favorites.favoritetvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.themoviedatabase.BuildConfig
import com.app.themoviedatabase.R
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
import com.app.themoviedatabase.databinding.ItemsFavoritesBinding
import com.app.themoviedatabase.ui.detail.tvshow.DetailTvShowActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FavoriteTvShowAdapter : PagedListAdapter<TvShowEntity, FavoriteTvShowAdapter.ViewHolder>(DIFF_CALLBACK) {

	companion object {
		private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
			override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
				return oldItem.tvShowId == newItem.tvShowId
			}
			override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
				return oldItem == newItem
			}
		}
	}

	inner class ViewHolder(private val binding: ItemsFavoritesBinding) :
		RecyclerView.ViewHolder(binding.root) {
		fun bind(tvShows: TvShowEntity) {
			with(binding) {
				Glide.with(itemView.context)
					.load("${BuildConfig.BASE_IMAGE_URL}${tvShows.imagePath}")
					.apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
					.error(R.drawable.ic_error)
					.into(imgPoster)
				tvMovieTitle.text = tvShows.title
				itemView.setOnClickListener {
					val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
					intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, tvShows.tvShowId)
					itemView.context.startActivity(intent)
				}
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val itemModuleListBinding = ItemsFavoritesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return ViewHolder(itemModuleListBinding)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val tvShows = getItem(position)
		if (tvShows != null) {
			holder.bind(tvShows)
		}

	}
}