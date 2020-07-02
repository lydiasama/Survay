package com.lydiasama.survey.authentication.data.source.token

interface AccessTokenDataSource {
    fun save(token: String)
    fun get(): String
    fun clear()
}
