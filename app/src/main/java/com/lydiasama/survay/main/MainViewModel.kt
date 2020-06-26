package com.lydiasama.survay.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lydiasama.survay.core.RxViewModel
import com.lydiasama.survay.survey.data.SurveyItem
import com.lydiasama.survay.survey.data.source.SurveyListDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val surveyListService: SurveyListDataSource) : RxViewModel() {
	private val _survayListLiveData = MutableLiveData<List<SurveyItem>>()
	val surveyListLiveData: LiveData<List<SurveyItem>> = _survayListLiveData

	fun getSurvayList() {
		val onNext: (List<SurveyItem>) -> Unit = { _survayListLiveData.value = it }

		surveyListService.getSurvayList()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeBy(onNext = onNext, onError = { Log.d("getSurvayList", it.toString()) })
				.addTo(compositeDisposable)
	}
}