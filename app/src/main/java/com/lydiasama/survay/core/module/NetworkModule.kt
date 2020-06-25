package com.lydiasama.survay.core.module

import com.lydiasama.survay.authentication.data.AuthenticationResult
import com.lydiasama.survay.authentication.data.source.AuthenticationApi
import com.lydiasama.survay.authentication.data.source.AuthenticationDataSource
import com.lydiasama.survay.authentication.data.source.AuthenticationMapper
import com.lydiasama.survay.authentication.data.source.AuthenticationService
import com.lydiasama.survay.authentication.token.AccessToken
import com.lydiasama.survay.authentication.token.AccessTokenDataSource
import com.lydiasama.survay.core.network.TokenInterceptor
import com.lydiasama.survay.core.network.OkHttpClientFactory
import com.lydiasama.survay.core.network.RetrofitFactory
import com.lydiasama.survay.core.network.TokenAuthenticator
import io.reactivex.functions.Function
import okhttp3.Authenticator
import okhttp3.Interceptor
import org.koin.dsl.module
import retrofit2.Response

val networkModule = module {
	factory<AuthenticationApi> {
		RetrofitFactory.createRetrofitWithOutInterceptor()
				.create(
						AuthenticationApi::class.java)
	}
	factory<Function<Response<AuthenticationResult>, AuthenticationResult>> { AuthenticationMapper() }
	factory<AuthenticationDataSource> {
		AuthenticationService(
				get(), get())
	}
	factory<AccessTokenDataSource> { AccessToken }
	factory<Authenticator> { TokenAuthenticator(get(), get()) }
	factory<Interceptor> { TokenInterceptor(get()) }
	factory {
		OkHttpClientFactory(get(), get()).createOkHttpClient()
	}
	single {
		RetrofitFactory.createRetrofit(get())
	}
}