package com.app.themoviedatabase.ui.favorites.favoritemovie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.themoviedatabase.BuildConfig
import com.app.themoviedatabase.R
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.databinding.ItemsFavoritesBinding
import com.app.themoviedatabase.ui.detail.movie.DetailMovieActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FavoriteMovieAdapter : PagedListAdapter<MovieEntity, FavoriteMovieAdapter.ViewHolder>(DIFF_CALLBACK) {
	companion object {
		private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
			override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
				return oldItem.movieId == newItem.movieId
			}
			override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
				return oldItem == newItem
			}
		}
	}

	inner class ViewHolder(private val binding: ItemsFavoritesBinding) :
		RecyclerView.ViewHolder(binding.root) {
		fun bind(movies: MovieEntity) {
			with(binding) {
				Glide.with(itemView.context)
					.load("${BuildConfig.BASE_IMAGE_URL}${movies.imagePath}")
					.apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
					.error(R.drawable.ic_error)
					.into(imgPoster)
				tvMovieTitle.text = movies.title
				itemView.setOnClickListener {
					val intent = Intent(itemView.context, DetailMovieActivity::class.java)
					intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies.movieId)
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
		val movies = getItem(position)
		if (movies != null) {
			holder.bind(movies)
		}
	}

}