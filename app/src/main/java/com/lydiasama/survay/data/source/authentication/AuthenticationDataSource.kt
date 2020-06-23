package com.lydiasama.survay.data.source.authentication

import io.reactivex.Observable


interface AuthenticationDataSource {
	fun getAccessToken(): Observable<String>
}