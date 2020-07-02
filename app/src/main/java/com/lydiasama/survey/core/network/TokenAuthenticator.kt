package com.lydiasama.survey.core.network

import com.lydiasama.survey.authentication.data.source.AuthenticationDataSource
import com.lydiasama.survey.authentication.data.source.token.AccessTokenDataSource
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class TokenAuthenticator(private val authenticationService: AuthenticationDataSource,
                         private val accessTokenPreference: AccessTokenDataSource) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        accessTokenPreference.clear()
        val newToken = getNewToken()
        return response.request.newBuilder()
                .addHeader("Authorization", "Bearer $newToken")
                .build()
    }

    private fun getNewToken(): String {
        return authenticationService.getAccessToken()
                .blockingFirst()
    }
}