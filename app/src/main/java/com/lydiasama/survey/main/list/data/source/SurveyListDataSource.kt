package com.lydiasama.survey.main.list.data.source

import com.lydiasama.survey.main.list.data.SurveyItem
import io.reactivex.Observable

interface SurveyListDataSource {
    fun getSurveyList(page: Int): Observable<List<SurveyItem>>
}