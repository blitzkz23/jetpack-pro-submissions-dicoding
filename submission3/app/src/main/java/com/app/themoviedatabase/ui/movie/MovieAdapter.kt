package com.app.themoviedatabase.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.themoviedatabase.BuildConfig
import com.app.themoviedatabase.R
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.databinding.ItemsMovieBinding
import com.app.themoviedatabase.ui.detail.movie.DetailMovieActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieAdapter : PagedListAdapter<MovieEntity, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

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

	class MovieViewHolder(private val binding: ItemsMovieBinding) :
		RecyclerView.ViewHolder(binding.root) {
		fun bind(movie: MovieEntity) {
			with(binding) {
				tvMovieTitle.text = movie.title
				tvMovieDate.text = movie.releaseDate
				tvMovieRate.text =
					itemView.context.getString(R.string.rating_placeholder, movie.score)
				itemView.setOnClickListener {
					val intent = Intent(itemView.context, DetailMovieActivity::class.java)
					intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
					itemView.context.startActivity(intent)
				}
				Glide.with(itemView.context)
					.load("${BuildConfig.BASE_IMAGE_URL}${movie.imagePath}")
					.apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
					.error(R.drawable.ic_error)
					.into(imgPoster)
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
		val itemsMovieBinding =
			ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return MovieViewHolder(itemsMovieBinding)
	}

	override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
		val movie = getItem(position)
		if (movie != null) {
			holder.bind(movie)
		}
	}
}