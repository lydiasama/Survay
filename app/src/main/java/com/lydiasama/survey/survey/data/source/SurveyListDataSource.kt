package com.lydiasama.survey.survey.data.source

import com.lydiasama.survey.survey.data.SurveyItem
import io.reactivex.Observable

interface SurveyListDataSource {
	fun getSurveyList(page: Int): Observable<List<SurveyItem>>
}