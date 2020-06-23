package com.lydiasama.survay

import android.app.Application
import com.lydiasama.survay.module.activityModule
import com.lydiasama.survay.module.appModule
import com.lydiasama.survay.module.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SurvayApplication : Application() {
	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidContext(this@SurvayApplication)
			modules(
					appModule,
					networkModule,
					activityModule
			)
			androidLogger()
		}
	}
}