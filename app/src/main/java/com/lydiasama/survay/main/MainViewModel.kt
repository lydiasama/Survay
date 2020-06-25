package com.lydiasama.survay.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lydiasama.survay.core.RxViewModel
import com.lydiasama.survay.survay.data.SurvayItem
import com.lydiasama.survay.survay.data.source.SurvayListDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val survayListService: SurvayListDataSource) : RxViewModel() {
	private val _survayListLiveData = MutableLiveData<List<SurvayItem>>()
	val survayListLiveData: LiveData<List<SurvayItem>> = _survayListLiveData

	fun getSurvayList() {
		val onNext: (List<SurvayItem>) -> Unit = { _survayListLiveData.value = it }

		survayListService.getSurvayList()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeBy(onNext = onNext, onError = { Log.d("getSurvayList", it.toString()) })
				.addTo(compositeDisposable)
	}
}