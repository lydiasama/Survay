package com.lydiasama.survey.core.services.authentication.data

import com.lydiasama.survey.BuildConfig

data class AuthenticationRequest(
        val grant_type: String = "password",
        val username: String = BuildConfig.USERNAME,
        val password: String = BuildConfig.PASSWORD
)

