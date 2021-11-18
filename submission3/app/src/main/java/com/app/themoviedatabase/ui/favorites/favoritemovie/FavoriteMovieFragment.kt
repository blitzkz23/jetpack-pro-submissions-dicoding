package com.app.themoviedatabase.ui.favorites.favoritemovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.app.themoviedatabase.data.ViewModelFactory
import com.app.themoviedatabase.databinding.FragmentFavoriteMovieBinding

class FavoriteMovieFragment : Fragment() {

	private var fragmentFavoriteMovieBinding: FragmentFavoriteMovieBinding? = null
	private lateinit var viewModel: FavoriteMovieViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		fragmentFavoriteMovieBinding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
		return fragmentFavoriteMovieBinding?.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val factory = ViewModelFactory.getInstance(requireActivity())
		viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]

		val favoriteMovieAdapter = FavoriteMovieAdapter()
		viewModel.getFavoriteMovies().observe(viewLifecycleOwner, { movies ->
			if (movies != null) {
				favoriteMovieAdapter.submitList(movies)
			}
		})

		fragmentFavoriteMovieBinding?.rvFav?.apply {
			layoutManager = GridLayoutManager(context, 2)
			setHasFixedSize(true)
			adapter = favoriteMovieAdapter
		}
	}

}