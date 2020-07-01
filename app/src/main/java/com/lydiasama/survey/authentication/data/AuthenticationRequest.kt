package com.lydiasama.survey.authentication.data

data class AuthenticationRequest(
        val grant_type: String = "password",
        val username: String = "carlos@nimbl3.com",
        val password: String = "antikera"
)

