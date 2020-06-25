package com.lydiasama.survay.core.module

import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

val appModule = module {
	factory { CompositeDisposable() }
}