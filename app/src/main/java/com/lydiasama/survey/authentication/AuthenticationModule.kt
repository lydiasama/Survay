package com.lydiasama.survey.authentication

import com.lydiasama.survey.authentication.data.AuthenticationResult
import com.lydiasama.survey.authentication.data.source.AuthenticationApi
import com.lydiasama.survey.authentication.data.source.AuthenticationDataSource
import com.lydiasama.survey.authentication.data.source.AuthenticationMapper
import com.lydiasama.survey.authentication.data.source.AuthenticationService
import com.lydiasama.survey.core.di.SubModule
import io.reactivex.functions.Function
import org.koin.dsl.ScopeDSL
import retrofit2.Response
import retrofit2.Retrofit

val authenticationDataSourceModule = object : SubModule {
	override fun invoke(scopeDsl: ScopeDSL) {
		scopeDsl.scoped<AuthenticationApi> {
			get<Retrofit>().create(AuthenticationApi::class.java)
		}
		scopeDsl.scoped<Function<Response<AuthenticationResult>, AuthenticationResult>> { AuthenticationMapper() }
		scopeDsl.scoped<AuthenticationDataSource> { AuthenticationService(get(), get()) }
	}
}