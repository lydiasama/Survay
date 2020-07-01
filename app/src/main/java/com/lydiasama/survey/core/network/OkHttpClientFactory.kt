package com.lydiasama.survey.core.network

import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class OkHttpClientFactory(private val tokenAuthenticator: Authenticator,
                          private val tokenInterceptor: Interceptor) {

	fun createOkHttpClient(): OkHttpClient {
		val logging = HttpLoggingInterceptor()
		logging.level = HttpLoggingInterceptor.Level.BODY

		return OkHttpClient.Builder()
				.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
				.readTimeout(TIMEOUT, TimeUnit.SECONDS)
				.authenticator(tokenAuthenticator)
				.addInterceptor(tokenInterceptor)
				.addInterceptor(logging)
				.build()
	}

	companion object {
		private const val TIMEOUT = 40L
	}
}