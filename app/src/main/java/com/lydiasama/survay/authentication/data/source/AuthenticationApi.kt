package com.lydiasama.survay.authentication.data.source

import com.lydiasama.survay.authentication.data.AuthenticationResult
import com.lydiasama.survay.authentication.data.AuthenticationRequest
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {
	@POST("/oauth/token")
	fun getAuthenticationToken(
			@Body authenticationRequest: AuthenticationRequest): Observable<Response<AuthenticationResult>>
}