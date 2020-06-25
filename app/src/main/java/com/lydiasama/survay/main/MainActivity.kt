package com.lydiasama.survay.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.lydiasama.survay.R
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class MainActivity : AppCompatActivity() {
	private val viewModel by lifecycleScope.viewModel<MainViewModel>(this)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		observeViewModel()
		viewModel.getSurvayList()
	}

	private fun observeViewModel() {
		viewModel.survayListLiveData.observe(this, Observer {
			//TODO submit list here
			Log.d("getSurvayList", it.toString())
		})
	}

	companion object {
		fun getStartIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
	}
}
