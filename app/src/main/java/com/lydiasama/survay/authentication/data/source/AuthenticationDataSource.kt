package com.lydiasama.survay.authentication.data.source

import io.reactivex.Observable


interface AuthenticationDataSource {
	fun getAccessToken(): Observable<String>
}