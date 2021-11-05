package com.app.themoviedatabase.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.themoviedatabase.R
import com.app.themoviedatabase.data.TvShowEntity
import com.app.themoviedatabase.databinding.ItemsMovieBinding
import com.app.themoviedatabase.ui.detail.tvshow.DetailTvShowActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
	private var listTvShows = ArrayList<TvShowEntity>()

	fun setTvShows(tvShows: List<TvShowEntity>?) {
		if (tvShows == null) return
		this.listTvShows.clear()
		this.listTvShows.addAll(tvShows)
	}

	class TvShowViewHolder(private val binding: ItemsMovieBinding) :
		RecyclerView.ViewHolder(binding.root) {
		fun bind(tvShow: TvShowEntity) {
			with(binding) {
				tvMovieTitle.text = tvShow.title
				tvMovieDate.text = tvShow.releaseDate
				tvMovieRate.text =
					itemView.context.getString(R.string.rating_placeholder, tvShow.score)
				tvMovieGenre.text = tvShow.genre
				itemView.setOnClickListener {
					val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
					intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, tvShow.tvShowId)
					itemView.context.startActivity(intent)
				}
				Glide.with(itemView.context)
					.load(tvShow.imagePath)
					.apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
					.error(R.drawable.ic_error)
					.into(imgPoster)
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
		val itemsMovieBinding =
			ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return TvShowViewHolder(itemsMovieBinding)
	}

	override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
		val tvShow = listTvShows[position]
		holder.bind(tvShow)
	}

	override fun getItemCount(): Int = listTvShows.size
}