package com.app.academy.ui.reader.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.academy.data.ModuleEntity
import com.app.academy.databinding.FragmentModuleContentBinding
import com.app.academy.ui.reader.CourseReaderViewModel


class ModuleContentFragment : Fragment() {

	companion object {
		val TAG: String = ModuleContentFragment::class.java.simpleName
		fun newInstance(): ModuleContentFragment = ModuleContentFragment()
	}

	private lateinit var fragmentModuleContentBinding: FragmentModuleContentBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		fragmentModuleContentBinding =
			FragmentModuleContentBinding.inflate(inflater, container, false)
		return fragmentModuleContentBinding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		if (activity != null) {
			val viewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())[CourseReaderViewModel::class.java]
			val module = viewModel.getSelectedModule()
			populateWebView(module)
		}
	}

	private fun populateWebView(module: ModuleEntity) {
		fragmentModuleContentBinding.webView.loadData(module.contentEntity?.content ?: "", "text/html", "UTF-8")
	}

}