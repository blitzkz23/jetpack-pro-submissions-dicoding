package com.app.themoviedatabase.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.themoviedatabase.databinding.FragmentTvShowBinding

class TvShowFragment : Fragment() {

	private var fragmentTvShowBinding: FragmentTvShowBinding? = null

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
		val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
		val tvShows = viewModel.getTvShows()

		val tvShowAdapter = TvShowAdapter()
		tvShowAdapter.setTvShows(tvShows)

		with(fragmentTvShowBinding!!.rvTvShow) {
			layoutManager = LinearLayoutManager(context)
			setHasFixedSize(true)
			adapter = tvShowAdapter
		}
	}

}