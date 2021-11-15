package com.app.mynoteappsroomdb.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.mynoteappsroomdb.ui.insert.NoteAddUpdateActivity
import com.app.mynoteappsroomdb.ui.insert.NoteAddUpdateViewModel
import com.app.mynoteappsroomdb.ui.main.MainViewModel

/**
 * Digunakan untuk mengirim konteks ke dalam ViewModel, yang nantinya digunakan untuk inisalisasi database di dalam NoteRepository.
 */
class ViewModelFactory private constructor(private val mApplication: Application) :
	ViewModelProvider.NewInstanceFactory() {
	companion object {
		@Volatile
		private var INSTANCE: ViewModelFactory? = null

		@JvmStatic
		fun getInstance(application: Application): ViewModelFactory {
			if (INSTANCE == null) {
				synchronized(ViewModelFactory::class.java) {
					INSTANCE = ViewModelFactory(application)
				}
			}
			return INSTANCE as ViewModelFactory
		}
	}

	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
			return MainViewModel(mApplication) as T
		} else if (modelClass.isAssignableFrom(NoteAddUpdateViewModel::class.java)) {
			return NoteAddUpdateViewModel(mApplication) as T
		}
		throw IllegalArgumentException("Uknown ViewModel class: ${modelClass.name}")

	}
}