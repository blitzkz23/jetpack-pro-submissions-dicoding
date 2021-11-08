package com.app.themoviedatabase.data.local.entity

data class TvShowEntity(
	val tvShowId: String,
	val title: String,
	val releaseDate: String,
	val overview: String,
	val genre: String,
	val score: Int,
	val duration: String,
	val imagePath: Int,
	var favorited: Boolean = false,
)
