package com.lydiasama.survey

import android.app.Application
import com.lydiasama.survey.core.di.module.appModule
import com.lydiasama.survey.core.di.module.mainModule
import com.lydiasama.survey.core.di.module.networkModule
import com.lydiasama.survey.core.di.module.splashModule
import com.lydiasama.survey.core.di.module.surveyDetailModule
import com.lydiasama.survey.core.di.module.surveyListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SurveyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SurveyApplication)
            modules(
                    appModule,
                    networkModule,
                    mainModule,
                    splashModule,
                    surveyListModule,
                    surveyDetailModule
            )
            androidLogger()
        }
    }
}