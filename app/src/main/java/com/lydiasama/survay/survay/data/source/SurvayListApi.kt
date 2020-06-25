package com.lydiasama.survay.survay.data.source

import com.lydiasama.survay.survay.data.SurvayItem
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface SurvayListApi {
	@GET("/surveys.json")
	fun getSurvayList(): Observable<Response<List<SurvayItem>>>
}