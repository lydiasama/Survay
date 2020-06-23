package com.lydiasama.survay.network

import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkHttpClientFactory(private val tokenAuthenticator: Authenticator,
                          private val tokenInterceptor: Interceptor) {
	fun createOkHttpClient(): OkHttpClient {
		return OkHttpClient.Builder()
				.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
				.readTimeout(TIMEOUT, TimeUnit.SECONDS)
				.authenticator(tokenAuthenticator)
				.addInterceptor(tokenInterceptor)
				.build()
	}

	companion object {
		private const val TIMEOUT = 40L
	}
}