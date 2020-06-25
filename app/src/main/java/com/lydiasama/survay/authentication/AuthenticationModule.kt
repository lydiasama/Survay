package com.lydiasama.survay.authentication

import com.lydiasama.survay.authentication.data.source.AuthenticationApi
import com.lydiasama.survay.authentication.data.source.AuthenticationDataSource
import com.lydiasama.survay.authentication.data.source.AuthenticationMapper
import com.lydiasama.survay.authentication.data.source.AuthenticationService
import com.lydiasama.survay.authentication.data.AuthenticationResult
import com.lydiasama.survay.core.di.SubModule
import io.reactivex.functions.Function
import org.koin.dsl.ScopeDSL
import retrofit2.Response
import retrofit2.Retrofit

val authenticationDataSourceModule = object : SubModule {
	override fun invoke(scopeDsl: ScopeDSL) {
		scopeDsl.scoped<AuthenticationApi>{ get<Retrofit>().create(
				AuthenticationApi::class.java) }
		scopeDsl.scoped<Function<Response<AuthenticationResult>, AuthenticationResult>>{ AuthenticationMapper() }
		scopeDsl.scoped<AuthenticationDataSource> {
			AuthenticationService(
					get(), get())
		}
	}
}