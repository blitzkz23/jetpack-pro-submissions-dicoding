package com.app.themoviedatabase.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.themoviedatabase.data.ViewModelFactory
import com.app.themoviedatabase.databinding.FragmentMovieBinding
import com.dicoding.academies.vo.Status

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
		viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
			if (movies != null) {
				when (movies.status) {
					Status.LOADING -> fragmentMovieBinding?.progressBar?.visibility = View.VISIBLE
					Status.SUCCESS -> {
						fragmentMovieBinding?.progressBar?.visibility = View.GONE
						movieAdapter.submitList(movies.data)
					}
					Status.ERROR -> {
						fragmentMovieBinding?.progressBar?.visibility = View.GONE
						Toast.makeText(context, "Data failed to load.", Toast.LENGTH_SHORT).show()
					}
				}
			}
		})

		fragmentMovieBinding?.rvMovie?.apply {
			layoutManager = LinearLayoutManager(context)
			setHasFixedSize(true)
			adapter = movieAdapter
		}
	}
}