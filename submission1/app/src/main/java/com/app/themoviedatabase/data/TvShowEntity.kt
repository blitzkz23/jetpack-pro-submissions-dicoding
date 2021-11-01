package com.app.themoviedatabase.data

data class TvShowEntity(
	var tvShowId: String,
	var title: String,
	var releaseDate: String,
	var overview: String,
	var genre: String,
	var score: Int,
	var duration: String,
	var imagePath: Int,
	var favorited: Boolean = false,
)
