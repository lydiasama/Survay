package com.lydiasama.survay.survay.data.source

import com.lydiasama.survay.survay.data.SurvayItem
import io.reactivex.Observable
import io.reactivex.functions.Function
import retrofit2.Response

class SurvayListService(private val survayListApi: SurvayListApi,
                        private val survayListMapper: Function<Response<List<SurvayItem>>, List<SurvayItem>>) :
		SurvayListDataSource {
	override fun getSurvayList(): Observable<List<SurvayItem>> {
		return survayListApi.getSurvayList()
				.map(survayListMapper)
	}
}