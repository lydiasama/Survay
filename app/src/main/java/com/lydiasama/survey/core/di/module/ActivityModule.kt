package com.lydiasama.survey.core.di.module

import com.lydiasama.survey.core.util.dialog.DialogUtil
import com.lydiasama.survey.core.util.dialog.DialogUtilImpl
import com.lydiasama.survey.main.MainActivity
import com.lydiasama.survey.main.detail.presenter.SurveyDetailFragment
import com.lydiasama.survey.main.detail.presenter.SurveyDetailViewModel
import com.lydiasama.survey.main.list.presenter.SurveyListFragment
import com.lydiasama.survey.main.list.presenter.SurveyListViewModel
import com.lydiasama.survey.main.list.presenter.adapter.SurveyListAdapter
import com.lydiasama.survey.splash.presenter.SplashActivity
import com.lydiasama.survey.splash.presenter.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var mainModule = module {
    factory { MainActivity }
}

val splashModule = module {
    scope<SplashActivity> {
        authenticationDataSourceModule(this)
        viewModel {
            SplashViewModel(get(), get())
        }
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

val surveyDetailModule = module {
    scope<SurveyDetailFragment> {
        viewModel { SurveyDetailViewModel() }
    }
}