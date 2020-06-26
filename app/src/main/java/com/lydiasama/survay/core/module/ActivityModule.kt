package com.lydiasama.survay.core.module

import com.lydiasama.survay.authentication.authenticationDataSourceModule
import com.lydiasama.survay.main.MainActivity
import com.lydiasama.survay.main.MainViewModel
import com.lydiasama.survay.splash.SplashActivity
import com.lydiasama.survay.splash.SplashViewModel
import com.lydiasama.survay.survey.surveyListDataSourceModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var mainModule = module {
	scope<MainActivity> {
		surveyListDataSourceModule(this)
		viewModel { MainViewModel(get()) }
	}
}

val splashModule = module {
	scope<SplashActivity> {
		authenticationDataSourceModule(this)
		viewModel { SplashViewModel(get(), get()) }
	}
}