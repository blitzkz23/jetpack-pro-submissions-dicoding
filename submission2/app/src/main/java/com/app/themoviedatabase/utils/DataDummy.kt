package com.app.themoviedatabase.utils

import com.app.themoviedatabase.R
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity

object DataDummy {

//	fun generateDummyMovies(): List<MovieEntity> {
//
//		val movies = ArrayList<MovieEntity>()
//
//		movies.add(
//			MovieEntity(
//				"1",
//				"A Star is Born",
//				"May 2, 2003",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Reality",
//				60,
//				"1h40m",
//				R.drawable.movie1,
//				false
//			)
//		)
//		movies.add(
//			MovieEntity(
//				"2",
//				"Alita Battle Angel",
//				"May 2, 2003",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Drama",
//				80,
//				"1h40m",
//				R.drawable.movie2,
//				false
//			)
//		)
//		movies.add(
//			MovieEntity(
//				"3",
//				"Aquaman",
//				"May 2, 2003",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Heroes",
//				60,
//				"1h40m",
//				R.drawable.movie3,
//				false
//			)
//		)
//		movies.add(
//			MovieEntity(
//				"4",
//				"Bohemian Rhapsody",
//				"May 2, 2003",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Reality",
//				90,
//				"1h40m",
//				R.drawable.movie4,
//				false
//			)
//		)
//		movies.add(
//			MovieEntity(
//				"5",
//				"Cold Pursuit",
//				"May 2, 2003",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Race",
//				70,
//				"1h40m",
//				R.drawable.movie5,
//				false
//			)
//		)
//		movies.add(
//			MovieEntity(
//				"6",
//				"Creed II",
//				"May 2, 2003",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Reality",
//				56,
//				"1h40m",
//				R.drawable.movie6,
//				false
//			)
//		)
//		movies.add(
//			MovieEntity(
//				"7",
//				"The Crimes of Grindelwald",
//				"May 2, 2003",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Reality",
//				50,
//				"1h40m",
//				R.drawable.movie7,
//				false
//			)
//		)
//		movies.add(
//			MovieEntity(
//				"8",
//				"Glass",
//				"May 2, 2003",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Mistery",
//				60,
//				"1h40m",
//				R.drawable.movie8,
//				false
//			)
//		)
//		movies.add(
//			MovieEntity(
//				"9",
//				"How to Train Your Dragon",
//				"May 2, 2003",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Animation, Fantasy",
//				70,
//				"1h40m",
//				R.drawable.movie9,
//				false
//			)
//		)
//		movies.add(
//			MovieEntity(
//				"10",
//				"Avenger Infinity War",
//				"May 2, 2003",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Hero",
//				70,
//				"1h40m",
//				R.drawable.movie10,
//				false
//			)
//		)
//		movies.add(
//			MovieEntity(
//				"11",
//				"Mary, Queen of Scottish",
//				"May 2, 2003",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Drama",
//				0,
//				"1h40m",
//				R.drawable.movie11,
//				false
//			)
//		)
//		movies.add(
//			MovieEntity(
//				"12",
//				"Master Z",
//				"May 2, 2003",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Reality",
//				50,
//				"1h40m",
//				R.drawable.movie12,
//				false
//			)
//		)
//		movies.add(
//			MovieEntity(
//				"13",
//				"Mortal Engines",
//				"May 2, 2003",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Reality",
//				80,
//				"1h40m",
//				R.drawable.movie13,
//				false
//			)
//		)
//		return movies
//	}

//	fun generateDummyTvShows(): List<TvShowEntity> {
//
//		val tvshows = ArrayList<TvShowEntity>()
//
//		tvshows.add(
//			TvShowEntity(
//				"1",
//				"Arrow",
//				"May 2, 2019",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Thriller",
//				70,
//				"1h40m",
//				R.drawable.tvshow1,
//				false
//			)
//		)
//		tvshows.add(
//			TvShowEntity(
//				"2",
//				"Doom Patrol",
//				"May 2, 2019",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Thriller",
//				70,
//				"1h40m",
//				R.drawable.tvshow2,
//				false
//			)
//		)
//		tvshows.add(
//			TvShowEntity(
//				"3",
//				"Dragon Ball",
//				"May 2, 2019",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Thriller",
//				70,
//				"1h40m",
//				R.drawable.tvshow3,
//				false
//			)
//		)
//		tvshows.add(
//			TvShowEntity(
//				"4",
//				"Fairy Tail",
//				"May 2, 2019",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Thriller",
//				70,
//				"1h40m",
//				R.drawable.tvshow4,
//				false
//			)
//		)
//		tvshows.add(
//			TvShowEntity(
//				"5",
//				"Family Guy",
//				"May 2, 2019",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Thriller",
//				70,
//				"1h40m",
//				R.drawable.tvshow5,
//				false
//			)
//		)
//		tvshows.add(
//			TvShowEntity(
//				"6",
//				"Flash",
//				"May 2, 2019",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Thriller",
//				70,
//				"1h40m",
//				R.drawable.tvshow6,
//				false
//			)
//		)
//		tvshows.add(
//			TvShowEntity(
//				"7",
//				"Got",
//				"May 2, 2019",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Thriller",
//				70,
//				"1h40m",
//				R.drawable.tvshow7,
//				false
//			)
//		)
//		tvshows.add(
//			TvShowEntity(
//				"8",
//				"Gotham",
//				"May 2, 2019",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Thriller",
//				70,
//				"1h40m",
//				R.drawable.tvshow8,
//				false
//			)
//		)
//		tvshows.add(
//			TvShowEntity(
//				"9",
//				"Grey Anatormty",
//				"May 2, 2019",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Thriller",
//				70,
//				"1h40m",
//				R.drawable.tvshow9,
//				false
//			)
//		)
//		tvshows.add(
//			TvShowEntity(
//				"10",
//				"Hanna",
//				"May 2, 2019",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Thriller",
//				70,
//				"1h40m",
//				R.drawable.tvshow10,
//				false
//			)
//		)
//		tvshows.add(
//			TvShowEntity(
//				"11",
//				"Iron Fist",
//				"May 2, 2019",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Thriller",
//				70,
//				"1h40m",
//				R.drawable.tvshow11,
//				false
//			)
//		)
//		tvshows.add(
//			TvShowEntity(
//				"12",
//				"Naruto Shippuden",
//				"May 2, 2019",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Thriller",
//				70,
//				"1h40m",
//				R.drawable.tvshow12,
//				false
//			)
//		)
//		tvshows.add(
//			TvShowEntity(
//				"13",
//				"NCIS",
//				"May 2, 2019",
//				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
//				"Action, Thriller",
//				70,
//				"1h40m",
//				R.drawable.tvshow13,
//				false
//			)
//		)
//		return tvshows
//	}
}