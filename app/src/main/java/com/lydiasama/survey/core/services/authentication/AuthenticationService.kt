package com.lydiasama.survey.core.services.authentication

import com.lydiasama.survey.core.services.authentication.data.AuthenticationRequest
import com.lydiasama.survey.core.services.authentication.data.AuthenticationResult
import com.lydiasama.survey.core.services.authentication.data.source.AuthenticationApi
import com.lydiasama.survey.core.services.authentication.data.source.AuthenticationDataSource
import com.lydiasama.survey.core.services.token.AccessTokenDataSource
import io.reactivex.Observable
import io.reactivex.functions.Function
import retrofit2.Response


class AuthenticationService(private val authenticationApi: AuthenticationApi,
                            private val authenticationMapper: Function<Response<AuthenticationResult>, AuthenticationResult>,
                            private val accessTokenPreference: AccessTokenDataSource) :
        AuthenticationDataSource {
    override fun getAccessToken(): Observable<String> {
        val currentAccessToken = accessTokenPreference.get()

        return if (currentAccessToken.isNotEmpty()) {
            Observable.just(currentAccessToken)
        } else {
            authenticationApi.getAuthenticationToken(
                    AuthenticationRequest())
                    .map(authenticationMapper)
                    .map { it.accessToken }
                    .doOnNext { newAccessToken ->
                        accessTokenPreference.save(newAccessToken)
                    }
        }
    }
}