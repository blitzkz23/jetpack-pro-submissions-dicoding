package com.app.themoviedatabase.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.app.themoviedatabase.R
import com.app.themoviedatabase.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setTheme(R.style.Theme_TheMovieDatabase)

		val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
		setContentView(activityHomeBinding.root)

		val sectionsPagerAdapter = SectionsPagerAdapter(this)
		val viewPager: ViewPager2 = activityHomeBinding.viewPager

		viewPager.adapter = sectionsPagerAdapter
		val tabs: TabLayout = activityHomeBinding.tabs
		val tabTitle = resources.getStringArray(R.array.tab_title)
		TabLayoutMediator(tabs, viewPager) { tab, position ->
			tab.text = tabTitle[position]
		}.attach()

		supportActionBar?.elevation = 0f

		supportActionBar?.setDisplayUseLogoEnabled(true)
		supportActionBar?.setLogo(R.drawable.splash)
	}
}