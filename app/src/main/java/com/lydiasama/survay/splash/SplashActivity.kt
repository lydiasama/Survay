package com.lydiasama.survay.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lydiasama.survay.core.EventObserver
import com.lydiasama.survay.main.MainActivity
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class SplashActivity : AppCompatActivity() {
	private val viewModel by lifecycleScope.viewModel<SplashViewModel>(this)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		observeViewModel()
		viewModel.login()
	}

	private fun observeViewModel() {
		viewModel.navigateToMainActivityEvent.observe(this, EventObserver {
			startActivity(MainActivity.getStartIntent(this))
			finish()
		})
	}
}
