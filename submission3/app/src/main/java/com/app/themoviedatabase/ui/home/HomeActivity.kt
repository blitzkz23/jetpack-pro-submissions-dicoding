package com.app.themoviedatabase.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.app.themoviedatabase.R
import com.app.themoviedatabase.databinding.ActivityHomeBinding
import com.app.themoviedatabase.ui.favorites.FavoritesActivity
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
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		val inflater = menuInflater
		inflater.inflate(R.menu.menu_home, menu)

		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return when (item.itemId) {
			R.id.favorites -> {
				val intent = Intent(this@HomeActivity, FavoritesActivity::class.java)
				startActivity(intent)
				true
			}
			else -> true
		}
	}
}