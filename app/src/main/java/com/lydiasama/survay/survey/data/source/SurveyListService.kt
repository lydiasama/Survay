package com.lydiasama.survay.survey.data.source

import com.lydiasama.survay.survey.data.SurveyItem
import io.reactivex.Observable
import io.reactivex.functions.Function
import retrofit2.Response

class SurveyListService(private val surveyListApi: SurveyListApi,
                        private val surveyListMapper: Function<Response<List<SurveyItem>>, List<SurveyItem>>) :
		SurveyListDataSource {
	override fun getSurvayList(): Observable<List<SurveyItem>> {
		return surveyListApi.getSurvayList()
				.map(surveyListMapper)
	}
}