package com.lydiasama.survay.survey.data.source

import com.lydiasama.survay.survey.data.SurveyItem
import io.reactivex.Observable

interface SurveyListDataSource {
	fun getSurvayList(): Observable<List<SurveyItem>>
}