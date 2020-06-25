package com.lydiasama.survay.core.network

import com.lydiasama.survay.authentication.token.AccessTokenDataSource
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthenticationInterceptor(private val accessTokenDataSource: AccessTokenDataSource) :
		Interceptor {
	override fun intercept(chain: Interceptor.Chain): Response {
		val originalRequest = chain.request()
		val token = accessTokenDataSource.get()
		val request = interceptRequest(originalRequest, token)

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