package com.lydiasama.survay.network

import android.util.Log
import com.lydiasama.survay.data.source.authentication.AuthenticationService
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import org.koin.java.KoinJavaComponent.inject

class TokenAuthenticator : Authenticator {
	override fun authenticate(route: Route?, response: Response): Request? {
		val updatedToken = getNewToken()
		Log.d("updatedToken", updatedToken)
		return response.request.newBuilder()
				.header("Authorization", updatedToken)
				.build()
	}

	private fun getNewToken(): String {
		val authenticationService: AuthenticationService by inject(
				AuthenticationService::class.java)
		return authenticationService.getAccessToken()
				.blockingFirst()
	}
}