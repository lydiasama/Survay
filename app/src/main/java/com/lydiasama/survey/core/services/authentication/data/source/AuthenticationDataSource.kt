package com.lydiasama.survey.core.services.authentication.data.source

import io.reactivex.Observable


interface AuthenticationDataSource {
    fun getAccessToken(): Observable<String>
}