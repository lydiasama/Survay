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
	private val _surveyListLiveData = MutableLiveData<List<SurveyItem>>()
	val surveyListLiveData: LiveData<List<SurveyItem>> = _surveyListLiveData

	private var _pagePosition = MutableLiveData(0)
	val pagePosition: LiveData<Int> = _pagePosition

	var page = 1
	var surveyList = listOf<SurveyItem>()
	fun getSurveyList() {
		val saveSurveyListIfNotEmpty: (List<SurveyItem>) -> Unit = {
			if (it.isNotEmpty()) {
				page++
				surveyList = surveyList + it
				getSurveyList()
			} else {
				_surveyListLiveData.value = surveyList
			}
		}

		surveyListService.getSurveyList(page)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeBy(onNext = saveSurveyListIfNotEmpty,
						onError = { Log.d("getSurveyList", it.toString()) })
				.addTo(compositeDisposable)
	}

	fun slidePage() {
		_pagePosition.value = _pagePosition.value?.plus(1)
	}
}