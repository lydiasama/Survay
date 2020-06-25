package com.lydiasama.survay.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lydiasama.survay.main.MainActivity
import com.lydiasama.survay.core.EventObserver
import org.koin.android.viewmodel.scope.viewModel
import org.koin.androidx.scope.lifecycleScope

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
