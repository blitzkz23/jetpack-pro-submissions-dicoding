package com.app.myviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.app.myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var activityMainBinding: ActivityMainBinding
//	Inisialisasi viewmodel biasa
//	private lateinit var viewModel: MainViewModel

//	inisialisasi viewmodel dengan ktx
	private val viewModel: MainViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(activityMainBinding.root)

//		Inisialisasi viewmodel biasa
//		viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

		displayResult()

		activityMainBinding.btnCalculate.setOnClickListener {
			val width = activityMainBinding.edtWidth.text.toString()
			val height = activityMainBinding.edtHeight.text.toString()
			val length = activityMainBinding.edtLength.text.toString()

			// validasi input
			when {
				width.isEmpty() -> {
					activityMainBinding.edtWidth.error = "Field tidak boleh kosong"
				}
				height.isEmpty() -> {
					activityMainBinding.edtHeight.error = "Field tidak boleh kosong"
				}
				length.isEmpty() -> {
					activityMainBinding.edtLength.error = "Field tidak boleh kosong"
				}
				else -> {
					viewModel.calculate(width, height, length)
					displayResult()
				}
			}
		}
	}

	private fun displayResult() {
		activityMainBinding.tvResult.text = viewModel.result.toString()
	}
}