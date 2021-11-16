package com.app.themoviedatabase.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.themoviedatabase.data.source.local.entity.MovieEntity
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity

@Database(
	entities = [MovieEntity::class, TvShowEntity::class],
	version = 1,
)
/**
 * Instance of local database room with two entities.
 */
abstract class MovieDbDatabase : RoomDatabase() {
	abstract fun movieDbDao(): MovieDbDao

	companion object {
		@Volatile
		private var INSTANCE: MovieDbDatabase? = null

		fun getInstance(context: Context): MovieDbDatabase =
			INSTANCE ?: synchronized(this) {
				Room.databaseBuilder(
					context.applicationContext,
					MovieDbDatabase::class.java,
					"MovieDb.db"
				).build().apply {
					INSTANCE = this
				}
			}
	}
}