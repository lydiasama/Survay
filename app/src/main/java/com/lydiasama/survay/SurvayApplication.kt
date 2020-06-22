package com.lydiasama.survay

import android.app.Application
import com.lydiasama.survay.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SurvayApplication : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidContext(this@SurvayApplication)
			modules(appModule)
		}
	}
}