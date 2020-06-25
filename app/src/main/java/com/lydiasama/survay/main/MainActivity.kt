package com.lydiasama.survay.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.lydiasama.survay.R

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		MainViewModel().listALiveData.observe(this, Observer {
			ArrayAdapter(this, android.R.layout.simple_list_item_1, it)
		})

	}

	companion object {
		fun getStartIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
	}
}
