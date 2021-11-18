package com.app.themoviedatabase.data.source.local.entity

data class MovieEntity(
	val movieId: Int,
	val title: String,
	val releaseDate: String,
	val overview: String,
	val language: String,
	val score: Double,
	val popularity: Double,
	val imagePath: String?,
	val backdropPath:String?
)
