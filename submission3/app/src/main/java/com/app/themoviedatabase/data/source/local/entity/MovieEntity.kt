package com.app.themoviedatabase.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntity(
	@PrimaryKey
	@NonNull
	@ColumnInfo(name = "movieId")
	val movieId: Int,

	@ColumnInfo(name = "title")
	val title: String,

	@ColumnInfo(name = "releaseDate")
	val releaseDate: String,

	@ColumnInfo(name = "overview")
	val overview: String,

	@ColumnInfo(name = "language")
	val language: String,

	@ColumnInfo(name = "score")
	val score: Double,

	@ColumnInfo(name = "popularity")
	val popularity: Double,

	@ColumnInfo(name = "imagePath")
	val imagePath: String?,

	@ColumnInfo(name = "backdropPath")
	val backdropPath:String?,

	@ColumnInfo(name = "favourited")
	var favourited: Boolean = false,
)
