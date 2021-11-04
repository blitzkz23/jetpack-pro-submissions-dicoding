package com.app.themoviedatabase.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.themoviedatabase.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {

	private lateinit var fragmentMovieBinding: FragmentMovieBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		// Inflate the layout for this fragment
		fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
		return fragmentMovieBinding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
		val movies = viewModel.getMovies()

		val movieAdapter = MovieAdapter()
		movieAdapter.setMovies(movies)

		with(fragmentMovieBinding.rvMovie) {
			layoutManager = LinearLayoutManager(context)
			setHasFixedSize(true)
			adapter = movieAdapter
		}

	}
}