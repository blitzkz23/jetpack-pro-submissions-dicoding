package com.app.themoviedatabase.ui.favorites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.app.themoviedatabase.R
import com.app.themoviedatabase.databinding.ActivityFavoritesBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FavoritesActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val activityFavoritesBinding = ActivityFavoritesBinding.inflate(layoutInflater)
		setContentView(activityFavoritesBinding.root)

		val sectionsPagerAdapter = FavoriteSectionsPagerAdapter(this)
		val viewPager: ViewPager2 = activityFavoritesBinding.viewPager

		viewPager.adapter = sectionsPagerAdapter
		val tabs: TabLayout = activityFavoritesBinding.tabs
		val tabTitle = resources.getStringArray(R.array.tab_title)
		TabLayoutMediator(tabs, viewPager) { tab, position ->
			tab.text = tabTitle[position]
		}.attach()

		supportActionBar?.elevation = 0f
		supportActionBar?.title = resources.getString(R.string.favourites)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
	}
}