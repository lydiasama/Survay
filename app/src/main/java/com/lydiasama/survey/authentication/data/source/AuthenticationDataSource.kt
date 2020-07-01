package com.lydiasama.survey.authentication.data.source

import io.reactivex.Observable


interface AuthenticationDataSource {
	fun getAccessToken(): Observable<String>
}