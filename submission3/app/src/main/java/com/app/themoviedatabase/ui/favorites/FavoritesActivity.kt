package com.app.themoviedatabase.ui.favorites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.themoviedatabase.R

class FavoritesActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_favorites)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
	}
}