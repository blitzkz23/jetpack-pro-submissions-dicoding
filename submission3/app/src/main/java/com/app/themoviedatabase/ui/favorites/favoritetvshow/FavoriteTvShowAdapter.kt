package com.app.themoviedatabase.ui.favorites.favoritetvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.themoviedatabase.BuildConfig
import com.app.themoviedatabase.R
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity
import com.app.themoviedatabase.databinding.ItemsFavoritesBinding
import com.app.themoviedatabase.ui.favorites.favoritemovie.FavoriteMovieAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FavoriteTvShowAdapter : RecyclerView.Adapter<FavoriteTvShowAdapter.ViewHolder>() {

	private val listFavorites = ArrayList<TvShowEntity>()

	fun setTvShows(tvShows: List<TvShowEntity>?) {
		if (tvShows == null) return
		this.listFavorites.clear()
		this.listFavorites.addAll(tvShows)
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
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val itemModuleListBinding = ItemsFavoritesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return ViewHolder(itemModuleListBinding)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val tvShows = listFavorites[position]
		holder.bind(tvShows)
	}

	override fun getItemCount(): Int = listFavorites.size
}