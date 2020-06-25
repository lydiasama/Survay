package com.lydiasama.survay.authentication.token

object AccessToken : AccessTokenDataSource {
	private var accessToken: String = ""
	override fun save(token: String) {
		accessToken = token
	}

	override fun get(): String {
		return accessToken
	}
}