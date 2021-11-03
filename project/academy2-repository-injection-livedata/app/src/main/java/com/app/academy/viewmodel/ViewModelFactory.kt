package com.app.academy.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.academy.data.source.AcademyRepository
import com.app.academy.di.Injection
import com.app.academy.ui.academy.AcademyViewModel
import com.app.academy.ui.bookmark.BookmarkViewModel
import com.app.academy.ui.detail.DetailCourseViewModel
import com.app.academy.ui.reader.CourseReaderViewModel

class ViewModelFactory private constructor(private val mAcademyRepository: AcademyRepository) :
	ViewModelProvider.NewInstanceFactory() {

	companion object {
		@Volatile
		private var instance: ViewModelFactory? = null

		fun getInstance(context: Context): ViewModelFactory =
			instance ?: synchronized(this) {
				instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
					instance = this
				}
			}
	}

	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		return when {
			modelClass.isAssignableFrom(AcademyViewModel::class.java) -> {
				AcademyViewModel(mAcademyRepository) as T
			}
			modelClass.isAssignableFrom(DetailCourseViewModel::class.java) -> {
				DetailCourseViewModel(mAcademyRepository) as T
			}
			modelClass.isAssignableFrom(BookmarkViewModel::class.java) -> {
				BookmarkViewModel(mAcademyRepository) as T
			}
			modelClass.isAssignableFrom(CourseReaderViewModel::class.java) -> {
				CourseReaderViewModel(mAcademyRepository) as T
			}
			else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
		}

	}

}