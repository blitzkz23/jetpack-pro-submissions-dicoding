package com.app.themoviedatabase.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.app.themoviedatabase.R
import com.app.themoviedatabase.ui.movie.MovieFragment
import com.app.themoviedatabase.ui.tvshow.TvShowFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

	override fun getItem(position: Int): Fragment {
		return when (position) {
			0 -> MovieFragment()
			1 -> TvShowFragment()
			else -> Fragment()
		}
	}

	override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

	override fun getCount(): Int = 2

	companion object {
		@StringRes
		private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tv_show)
	}
}