package com.lydiasama.survey.core.di.module

import com.lydiasama.survey.core.util.shared.preferences.SharedPreferencesUtil
import com.lydiasama.survey.core.util.shared.preferences.SurveySharedPreferences
import com.lydiasama.survey.core.util.dialog.DialogUtil
import com.lydiasama.survey.core.util.dialog.DialogUtilImpl
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory { CompositeDisposable() }
    factory<DialogUtil> { DialogUtilImpl }
    single<SharedPreferencesUtil> {
        SurveySharedPreferences(
                androidContext())
    }
}