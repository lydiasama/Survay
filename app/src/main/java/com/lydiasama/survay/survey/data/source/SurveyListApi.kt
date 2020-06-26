package com.lydiasama.survay.survey.data.source

import com.lydiasama.survay.survey.data.SurveyItem
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface SurveyListApi {
	@GET("/surveys.json")
	fun getSurvayList(): Observable<Response<List<SurveyItem>>>
}