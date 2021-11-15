package com.app.mynoteappsroomdb.ui.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import com.app.mynoteappsroomdb.database.Note
import com.app.mynoteappsroomdb.repository.NoteRepository

/**
 * Class ini digunakan sebagai penghubung antara Activity dengan Repository
 */
class NoteAddUpdateViewModel(application: Application) : ViewModel() {
	private val mNoteRepository: NoteRepository = NoteRepository(application)

	fun insert(note: Note) {
		mNoteRepository.insert(note)
	}

	fun update(note: Note) {
		mNoteRepository.update(note)
	}

	fun delete(note: Note) {
		mNoteRepository.delete(note)
	}
}