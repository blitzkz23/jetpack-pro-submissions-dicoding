package com.app.themoviedatabase.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.themoviedatabase.data.ViewModelFactory
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

		val factory = ViewModelFactory.getInstance(requireActivity())
		viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

		val movieAdapter = MovieAdapter()
		fragmentMovieBinding?.progressBar?.visibility = View.VISIBLE
		viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
			fragmentMovieBinding?.progressBar?.visibility = View.GONE
			movieAdapter.setMovies(movies)
			movieAdapter.notifyDataSetChanged()
		})

		fragmentMovieBinding?.rvMovie?.apply {
			layoutManager = LinearLayoutManager(context)
			setHasFixedSize(true)
			adapter = movieAdapter
		}
	}
}