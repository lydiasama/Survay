package com.lydiasama.survay.core.network

import com.lydiasama.survay.authentication.data.source.AuthenticationDataSource
import com.lydiasama.survay.authentication.token.AccessTokenDataSource
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class TokenAuthenticator(private val authenticationDataSource: AuthenticationDataSource,
                         private val accessTokenDataSource: AccessTokenDataSource) : Authenticator {
	override fun authenticate(route: Route?, response: Response): Request? {
		return response.request.newBuilder()
				.addHeader("Authorization", "Bearer ${accessTokenDataSource.get()}")
				.build()
	}

	private fun getNewToken(): String {
		return authenticationDataSource.getAccessToken()
				.blockingFirst()
	}
}