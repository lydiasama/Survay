package com.lydiasama.survay.data.source.authentication

import com.lydiasama.survay.data.AuthenticationResult
import io.reactivex.Observable
import io.reactivex.functions.Function
import retrofit2.Response


class AuthenticationService(private val authenticationApi: AuthenticationApi,
                            private val authenticationMapper: Function<Response<AuthenticationResult>, AuthenticationResult>) :
		AuthenticationDataSource {
	override fun getAccessToken(): Observable<String> {
		return authenticationApi.getAuthenticationToken()
				.map(authenticationMapper)
				.map { it.accessToken }
	}
}