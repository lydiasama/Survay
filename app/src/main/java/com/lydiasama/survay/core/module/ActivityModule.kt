package com.lydiasama.survay.core.module

import com.lydiasama.survay.main.MainActivity
import com.lydiasama.survay.authentication.authenticationDataSourceModule
import com.lydiasama.survay.main.MainViewModel
import com.lydiasama.survay.splash.SplashActivity
import com.lydiasama.survay.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var activityModule = module {
	scope<MainActivity> {
		viewModel { MainViewModel() }
	}
}

val splashModule = module {
	scope<SplashActivity> {
		authenticationDataSourceModule(this)
		viewModel { SplashViewModel(get()) }
	}
}