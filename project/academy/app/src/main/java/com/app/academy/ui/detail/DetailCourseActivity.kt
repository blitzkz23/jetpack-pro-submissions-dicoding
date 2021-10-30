package com.app.academy.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.RoundedCorner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.academy.R
import com.app.academy.data.CourseEntity
import com.app.academy.databinding.ActivityDetailCourseBinding
import com.app.academy.databinding.ContentDetailCourseBinding
import com.app.academy.ui.detail.DetailCourseActivity.Companion.EXTRA_COURSE
import com.app.academy.ui.reader.CourseReaderActivity
import com.app.academy.utils.DataDummy
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailCourseActivity : AppCompatActivity() {

	private lateinit var detailContentBinding: ContentDetailCourseBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val activityDetailCourseBinding = ActivityDetailCourseBinding.inflate(layoutInflater)
		detailContentBinding = activityDetailCourseBinding.detailContent

		setContentView(activityDetailCourseBinding.root)

		setSupportActionBar(activityDetailCourseBinding.toolbar)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)

		val adapter = DetailCourseAdapter()

		val extras = intent.extras
		if (extras != null) {
			val courseId = extras.getString(EXTRA_COURSE)
			if (courseId != null) {
				val modules = DataDummy.generateDummyModules(courseId)
				adapter.setModules(modules)
				for (course in DataDummy.generateDummyCourses()) {
					if (course.courseId == courseId) {
						populateCourse(course)
					}
				}
			}
		}

		with(detailContentBinding.rvModule) {
			isNestedScrollingEnabled = false
			layoutManager = LinearLayoutManager(this@DetailCourseActivity)
			setHasFixedSize(true)
			this.adapter = adapter
			val dividerItemDecoration =
				DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
			addItemDecoration(dividerItemDecoration)
		}
	}

	private fun populateCourse(courseEntity: CourseEntity) {
		with(detailContentBinding) {
			textTitle.text = courseEntity.title
			textDescription.text = courseEntity.description
			textDate.text = resources.getString(R.string.deadline_date, courseEntity.deadline)
		}

		Glide.with(this)
			.load(courseEntity.imagePath)
			.transform(RoundedCorners(20))
			.apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_loading))
			.into(detailContentBinding.imagePoster)

		detailContentBinding.btnStart.setOnClickListener {
			val intent = Intent(this@DetailCourseActivity, CourseReaderActivity::class.java)
			intent.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, courseEntity.courseId)
			startActivity(intent)
		}
	}

	companion object {
		const val EXTRA_COURSE = "extra_course"
	}

}