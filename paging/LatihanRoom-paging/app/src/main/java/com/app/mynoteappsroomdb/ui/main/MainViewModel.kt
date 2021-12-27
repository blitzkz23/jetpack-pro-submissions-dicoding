package com.app.mynoteappsroomdb.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.app.mynoteappsroomdb.database.Note
import com.app.mynoteappsroomdb.repository.NoteRepository

/**
 * Inisialisasi repository dan fungsi get data
 */
class MainViewModel(application: Application) : ViewModel() {
	private val mNoteRepository: NoteRepository = NoteRepository(application)

	fun getAllNotes(): LiveData<PagedList<Note>> = LivePagedListBuilder(mNoteRepository.getAllNotes(), 20).build()
//	fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()
}
