package com.lydiasama.survey.core.network

import com.lydiasama.survey.authentication.data.source.AuthenticationDataSource
import com.lydiasama.survey.authentication.token.AccessTokenDataSource
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class TokenAuthenticator(private val authenticationDataSource: AuthenticationDataSource,
                         private val accessTokenDataSource: AccessTokenDataSource) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        val newToken = getNewToken()
        accessTokenDataSource.save(newToken)
        return response.request.newBuilder()
                .addHeader("Authorization", "Bearer $newToken")
                .build()
    }

    private fun getNewToken(): String {
        return authenticationDataSource.getAccessToken()
                .blockingFirst()
    }
}