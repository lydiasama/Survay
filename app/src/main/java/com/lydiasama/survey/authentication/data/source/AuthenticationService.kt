package com.lydiasama.survey.authentication.data.source

import com.lydiasama.survey.authentication.data.AuthenticationResult
import com.lydiasama.survey.authentication.data.AuthenticationRequest
import io.reactivex.Observable
import io.reactivex.functions.Function
import retrofit2.Response


class AuthenticationService(private val authenticationApi: AuthenticationApi,
                            private val authenticationMapper: Function<Response<AuthenticationResult>, AuthenticationResult>) :
		AuthenticationDataSource {
	override fun getAccessToken(): Observable<String> {
		return authenticationApi.getAuthenticationToken(
				AuthenticationRequest())
				.map(authenticationMapper)
				.map { it.accessToken }
	}
}