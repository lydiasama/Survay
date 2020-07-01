package com.lydiasama.survay.core.module

import com.lydiasama.survay.util.dialog.DialogUtil
import com.lydiasama.survay.util.dialog.DialogUtilImpl
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

val appModule = module {
	factory { CompositeDisposable() }
	factory<DialogUtil> { DialogUtilImpl }
}