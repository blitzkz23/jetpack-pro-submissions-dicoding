package com.app.themoviedatabase.ui.favorites.favoritemovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.themoviedatabase.BuildConfig
import com.app.themoviedatabase.R
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.databinding.ItemsFavoritesBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FavoriteMovieAdapter : RecyclerView.Adapter<FavoriteMovieAdapter.ViewHolder>() {

	private val listFavorites = ArrayList<MovieEntity>()

	fun setMovies(movies: List<MovieEntity>?) {
		if (movies == null) return
		this.listFavorites.clear()
		this.listFavorites.addAll(movies)
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
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val itemModuleListBinding = ItemsFavoritesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return ViewHolder(itemModuleListBinding)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val movies = listFavorites[position]
		holder.bind(movies)
	}

	override fun getItemCount(): Int = listFavorites.size
}