package com.app.themoviedatabase.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.themoviedatabase.R
import com.app.themoviedatabase.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setTheme(R.style.Theme_TheMovieDatabase)

		val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
		setContentView(activityHomeBinding.root)

		val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
		activityHomeBinding.viewPager.adapter = sectionsPagerAdapter
		activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)

		supportActionBar?.elevation = 0f

		supportActionBar?.setDisplayUseLogoEnabled(true)
		supportActionBar?.setLogo(R.drawable.splash)
	}
}