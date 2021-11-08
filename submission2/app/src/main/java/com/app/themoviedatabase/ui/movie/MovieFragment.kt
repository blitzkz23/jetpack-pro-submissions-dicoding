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

	private var fragmentMovieBinding: FragmentMovieBinding? = null
	private lateinit var viewModel: MovieViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
		return fragmentMovieBinding?.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel = obtainViewModel()
		val movies = viewModel.getMovies()

		val movieAdapter = MovieAdapter()
		movieAdapter.setMovies(movies)


		with(fragmentMovieBinding!!.rvMovie) {
			layoutManager = LinearLayoutManager(context)
			setHasFixedSize(true)
			adapter = movieAdapter
		}
	}

	private fun obtainViewModel() = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
}