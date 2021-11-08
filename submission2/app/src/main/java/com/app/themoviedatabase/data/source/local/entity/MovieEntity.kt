package com.app.themoviedatabase.data.source.local.entity

data class MovieEntity(
	val movieId: Int,
	val title: String,
	val releaseDate: String,
	val overview: String,
	val genre: String,
	val score: Int,
	val duration: String,
	val imagePath: Int,
	var favorited: Boolean = false,
)
