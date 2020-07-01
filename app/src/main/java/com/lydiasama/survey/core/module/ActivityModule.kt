package com.lydiasama.survey.core.module

import com.lydiasama.survey.authentication.authenticationDataSourceModule
import com.lydiasama.survey.main.MainActivity
import com.lydiasama.survey.main.list.SurveyListFragment
import com.lydiasama.survey.main.list.SurveyListViewModel
import com.lydiasama.survey.main.list.adapter.SurveyListAdapter
import com.lydiasama.survey.splash.SplashActivity
import com.lydiasama.survey.splash.SplashViewModel
import com.lydiasama.survey.survey.surveyListDataSourceModule
import com.lydiasama.survey.util.dialog.DialogUtil
import com.lydiasama.survey.util.dialog.DialogUtilImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var mainModule = module {
    factory { MainActivity }
}

val splashModule = module {
    scope<SplashActivity> {
        authenticationDataSourceModule(this)
        viewModel { SplashViewModel(get(), get()) }
    }
}

val surveyListModule = module {
    scope<SurveyListFragment> {
        surveyListDataSourceModule(this)
        viewModel { SurveyListViewModel(get()) }
        scoped { SurveyListAdapter() }
        scoped<DialogUtil> { DialogUtilImpl }
    }
}