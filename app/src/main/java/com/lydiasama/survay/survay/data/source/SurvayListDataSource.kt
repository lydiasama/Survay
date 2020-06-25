package com.lydiasama.survay.survay.data.source

import com.lydiasama.survay.survay.data.SurvayItem
import io.reactivex.Observable

interface SurvayListDataSource {
	fun getSurvayList(): Observable<List<SurvayItem>>
}