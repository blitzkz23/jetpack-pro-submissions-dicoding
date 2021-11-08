package com.app.themoviedatabase.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.themoviedatabase.databinding.ActivitySplashBinding
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

	private var activitySplashBinding: ActivitySplashBinding? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		activitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
		setContentView(activitySplashBinding?.root)

		CoroutineScope(Dispatchers.Default).launch {
			delay(2000)
			withContext(Dispatchers.Main) {
				val intent = Intent(this@SplashActivity , HomeActivity::class.java)
				startActivity(intent)
				finish()
			}
		}
	}
}