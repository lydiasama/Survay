package com.lydiasama.survey.main.list.services

import com.lydiasama.survey.main.list.data.SurveyItem
import com.lydiasama.survey.main.list.data.source.SurveyListApi
import com.lydiasama.survey.main.list.data.source.SurveyListDataSource
import io.reactivex.Observable
import io.reactivex.functions.Function
import retrofit2.Response

class SurveyListService(private val surveyListApi: SurveyListApi,
                        private val surveyListMapper: Function<Response<List<SurveyItem>>, List<SurveyItem>>) :
        SurveyListDataSource {
    override fun getSurveyList(page: Int): Observable<List<SurveyItem>> {
        return surveyListApi.getSurveyList(page = page, perPage = PER_PAGE)
                .map(surveyListMapper)
    }

    companion object {
        const val PER_PAGE = 10
    }
}