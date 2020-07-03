package com.lydiasama.survey.core.services.token

interface AccessTokenDataSource {
    fun save(token: String)
    fun get(): String
    fun clear()
}
