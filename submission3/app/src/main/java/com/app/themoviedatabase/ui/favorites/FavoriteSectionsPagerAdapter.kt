package com.app.themoviedatabase.ui.favorites

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.app.themoviedatabase.ui.favorites.favoritemovie.FavoriteMovieFragment
import com.app.themoviedatabase.ui.favorites.favoritetvshow.FavoriteTvShowFragment
import com.app.themoviedatabase.ui.movie.MovieFragment
import com.app.themoviedatabase.ui.tvshow.TvShowFragment

class FavoriteSectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

	override fun getItemCount(): Int = 2

	override fun createFragment(position: Int): Fragment {
		var fragment: Fragment? = null
		when (position) {
			0 -> fragment = FavoriteMovieFragment()
			1 -> fragment = FavoriteTvShowFragment()
			else -> Fragment()
		}
		return fragment as Fragment
	}
}