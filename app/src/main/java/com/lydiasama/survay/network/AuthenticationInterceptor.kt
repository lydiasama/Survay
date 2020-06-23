package com.lydiasama.survay.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {
	override fun intercept(chain: Interceptor.Chain): Response {
		val originalRequest = chain.request()
		val token = "" // TODO Get from share pref.
		val request = interceptRequest(chain.request(), token)

		return chain.proceed(request)
				.newBuilder()
				.build()
	}

	private fun interceptRequest(request: Request, token: String): Request {
		return request.newBuilder()
				.header("Authorization", token)
				.build()
	}
}