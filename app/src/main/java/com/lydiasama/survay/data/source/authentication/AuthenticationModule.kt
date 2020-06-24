package com.lydiasama.survay.data.source.authentication

import com.lydiasama.survay.data.AuthenticationResult
import io.reactivex.functions.Function
import org.koin.dsl.module
import retrofit2.Response
import retrofit2.Retrofit

val authenticationModule = module {
	factory<AuthenticationApi> { get<Retrofit>().create(AuthenticationApi::class.java) }
	factory<Function<Response<AuthenticationResult>, AuthenticationResult>> { AuthenticationMapper() }
	factory<AuthenticationDataSource> { AuthenticationService(get(), get()) }
}