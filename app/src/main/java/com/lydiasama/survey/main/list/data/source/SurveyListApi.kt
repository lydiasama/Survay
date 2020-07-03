package com.lydiasama.survey.main.list.data.source

import com.lydiasama.survey.main.list.data.SurveyItem
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SurveyListApi {
    @GET("/surveys.json")
    fun getSurveyList(@Query("page") page: Int,
                      @Query("per_page") perPage: Int): Observable<Response<List<SurveyItem>>>
}