package com.app.mynoteappsroomdb.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.app.mynoteappsroomdb.database.Note
import com.app.mynoteappsroomdb.database.NoteDao
import com.app.mynoteappsroomdb.database.NoteRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Untuk berhubungan dengan database, menggunakan metode dari NoteDao
 */
class NoteRepository(application: Application) {
	private val mNotesDao: NoteDao
	private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

	init {
		val db = NoteRoomDatabase.getDatabase(application)
		mNotesDao = db.noteDao()
	}

	fun getAllNotes(): DataSource.Factory<Int, Note> {
		return mNotesDao.getAllNotes()
	}

	fun insert(note: Note) {
		executorService.execute { mNotesDao.insert(note) }
	}

	fun delete(note: Note) {
		executorService.execute { mNotesDao.delete(note) }
	}

	fun update(note: Note) {
		executorService.execute { mNotesDao.update(note) }
	}
}