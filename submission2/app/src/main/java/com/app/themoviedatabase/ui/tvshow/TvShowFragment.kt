package com.app.themoviedatabase.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.themoviedatabase.data.ViewModelFactory
import com.app.themoviedatabase.databinding.FragmentTvShowBinding

class TvShowFragment : Fragment() {

	private var fragmentTvShowBinding: FragmentTvShowBinding? = null
	private lateinit var viewModel: TvShowViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
		return fragmentTvShowBinding?.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val factory = ViewModelFactory.getInstance(requireActivity())
		viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

		val tvShowAdapter = TvShowAdapter()
		fragmentTvShowBinding?.progressBar?.visibility = View.VISIBLE
		viewModel.getTvShows().observe(viewLifecycleOwner, { tvShows ->
			fragmentTvShowBinding?.progressBar?.visibility = View.GONE
			tvShowAdapter.setTvShows(tvShows)
			tvShowAdapter.notifyDataSetChanged()
		})

		fragmentTvShowBinding?.rvTvShow?.apply{
			layoutManager = LinearLayoutManager(context)
			setHasFixedSize(true)
			adapter = tvShowAdapter
		}
	}


}