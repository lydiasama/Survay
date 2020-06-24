package com.lydiasama.survay.module

import com.lydiasama.survay.data.source.authentication.authenticationModule
import org.koin.dsl.module

val apiModule = module {
	authenticationModule
}