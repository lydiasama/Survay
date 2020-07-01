package com.lydiasama.survey.authentication.token

interface AccessTokenDataSource {
    fun save(token: String)
    fun get(): String
}
