package com.lydiasama.survey.core.services.authentication.data.source

import com.lydiasama.survey.core.services.authentication.data.AuthenticationRequest
import com.lydiasama.survey.core.services.authentication.data.AuthenticationResult
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {
    @POST("/oauth/token")
    fun getAuthenticationToken(
            @Body authenticationRequest: AuthenticationRequest): Observable<Response<AuthenticationResult>>
}