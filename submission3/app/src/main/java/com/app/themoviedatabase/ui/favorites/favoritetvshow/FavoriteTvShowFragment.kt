package com.app.themoviedatabase.ui.favorites.favoritetvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.app.themoviedatabase.data.ViewModelFactory
import com.app.themoviedatabase.databinding.FragmentFavoriteTvShowBinding

class FavoriteTvShowFragment : Fragment() {

	private var fragmentFavoriteTvShowBinding: FragmentFavoriteTvShowBinding? = null
	private lateinit var viewModel: FavoriteTvShowViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		fragmentFavoriteTvShowBinding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
		return fragmentFavoriteTvShowBinding?.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val factory = ViewModelFactory.getInstance(requireActivity())
		viewModel = ViewModelProvider(this, factory)[FavoriteTvShowViewModel::class.java]

		val favoriteTvShowAdapter = FavoriteTvShowAdapter()
		viewModel.getFavouritedTvShows().observe(viewLifecycleOwner, { tvShows ->
			if (tvShows != null) {
				favoriteTvShowAdapter.submitList(tvShows)
			}
		})

		fragmentFavoriteTvShowBinding?.rvFav?.apply {
			layoutManager = GridLayoutManager(context, 2)
			setHasFixedSize(true)
			adapter = favoriteTvShowAdapter
		}
	}

}