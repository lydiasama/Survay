package com.lydiasama.survay.data.source.authentication

import com.lydiasama.survay.data.AuthenticationResult
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.POST

interface AuthenticationApi {
	@POST("/oauth/token")
	fun getAuthenticationToken(): Observable<Response<AuthenticationResult>>
}