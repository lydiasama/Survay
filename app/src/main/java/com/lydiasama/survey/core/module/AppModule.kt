package com.lydiasama.survey.core.module

import com.lydiasama.survey.util.SharedPreferencesUtil
import com.lydiasama.survey.util.SurveySharedPreferences
import com.lydiasama.survey.util.dialog.DialogUtil
import com.lydiasama.survey.util.dialog.DialogUtilImpl
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory { CompositeDisposable() }
    factory<DialogUtil> { DialogUtilImpl }
    single<SharedPreferencesUtil> { SurveySharedPreferences(androidContext()) }
}