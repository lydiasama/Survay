package com.lydiasama.survay.network

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class TokenAuthenticator : Authenticator {
	override fun authenticate(route: Route?, response: Response): Request? {
		val updatedToken = getNewToken()
		return response.request.newBuilder()
				.header("Authorization", updatedToken)
				.build()
	}

	private fun getNewToken(): String {
		// TODO Call authen usecase here and save to Shared pref
		return ""
	}
}