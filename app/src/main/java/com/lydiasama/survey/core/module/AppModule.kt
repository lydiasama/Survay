package com.lydiasama.survey.core.module

import com.lydiasama.survey.util.dialog.DialogUtil
import com.lydiasama.survey.util.dialog.DialogUtilImpl
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

val appModule = module {
	factory { CompositeDisposable() }
	factory<DialogUtil> { DialogUtilImpl }
}