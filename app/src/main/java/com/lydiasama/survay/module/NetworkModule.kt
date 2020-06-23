package com.lydiasama.survay.module

import com.lydiasama.survay.network.AuthenticationInterceptor
import com.lydiasama.survay.network.OkHttpClientFactory
import com.lydiasama.survay.network.RetrofitFactory
import com.lydiasama.survay.network.TokenAuthenticator
import okhttp3.Authenticator
import okhttp3.Interceptor
import org.koin.dsl.module

val networkModule = module {
	factory<Authenticator> { TokenAuthenticator() }
	factory<Interceptor> { AuthenticationInterceptor() }
	factory {
		OkHttpClientFactory(get(), get()).createOkHttpClient()
	}
	single {
		RetrofitFactory(get())
				.createRetrofit()
	}
}