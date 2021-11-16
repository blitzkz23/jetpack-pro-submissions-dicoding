package com.app.themoviedatabase.data.source.local.entity

data class TvShowEntity(
	val tvShowId: Int,
	val title: String?,
	val releaseDate: String,
	val overview: String,
	val language: String,
	val score: Double,
	val popularity: Double,
	val imagePath: String?,
	val backdropPath:String?,
	var favorited: Boolean = false,
)
