package com.lydiasama.survay.authentication.token

interface AccessTokenDataSource {
	fun save(token: String)
	fun get(): String
}
