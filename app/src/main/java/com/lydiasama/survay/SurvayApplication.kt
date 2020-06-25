package com.lydiasama.survay

import android.app.Application
import com.lydiasama.survay.core.module.activityModule
import com.lydiasama.survay.core.module.apiModule
import com.lydiasama.survay.core.module.appModule
import com.lydiasama.survay.core.module.networkModule
import com.lydiasama.survay.core.module.splashModule
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
					apiModule,
					activityModule,splashModule
			)
			androidLogger()
		}
	}
}