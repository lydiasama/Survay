package com.lydiasama.survay.authentication.data

import com.google.gson.annotations.SerializedName

data class AuthenticationResult(
		@SerializedName("access_token")
		val accessToken: String = "",
		@SerializedName("created_at")
		val createdAt: Int = 0,
		@SerializedName("expires_in")
		val expiresIn: Int = 0,
		@SerializedName("token_type")
		val tokenType: String = ""
)