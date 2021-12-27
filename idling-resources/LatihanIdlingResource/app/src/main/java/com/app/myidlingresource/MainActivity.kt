package com.app.myidlingresource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.app.EspressoIdlingResource
import com.app.myidlingresource.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var activityMainBinding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {

		super.onCreate(savedInstanceState)
		activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(activityMainBinding.root)

		activityMainBinding.button.setOnClickListener {
			delay1()
			delay2()
		}

	}

	private fun delay1() {
		EspressoIdlingResource.increment()
		Handler(Looper.getMainLooper()).postDelayed({
			activityMainBinding.textView.text = getString(R.string.delay1)
			if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
				EspressoIdlingResource.decrement()
			}
		}, 2000)
	}

	private fun delay2() {
		EspressoIdlingResource.increment()
		Handler(Looper.getMainLooper()).postDelayed({
			activityMainBinding.textView.text = getString(R.string.delay2)
			if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
				EspressoIdlingResource.decrement()
			}
		}, 3000)
	}

}