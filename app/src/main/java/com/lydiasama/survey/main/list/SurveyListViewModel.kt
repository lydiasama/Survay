package com.lydiasama.survey.main.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lydiasama.survey.core.Event
import com.lydiasama.survey.core.RxViewModel
import com.lydiasama.survey.survey.data.SurveyItem
import com.lydiasama.survey.survey.data.source.SurveyListDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class SurveyListViewModel(private val surveyListService: SurveyListDataSource) : RxViewModel() {
    private val _surveyListLiveData = MutableLiveData<List<SurveyItem>>()
    val surveyListLiveData: LiveData<List<SurveyItem>> = _surveyListLiveData

    private var _pagePosition = MutableLiveData(0)
    val pagePosition: LiveData<Int> = _pagePosition

    private var _errorEvent = MutableLiveData<Event<String?>>()
    val errorEvent: LiveData<Event<String?>> = _errorEvent

    var page = 1
    var surveyList = listOf<SurveyItem>()
    fun getSurveyList() {
        surveyListService.getSurveyList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(onNext = ::saveSurveyListIfNotEmpty,
                        onError = { _errorEvent.value = Event(it.message) })
                .addTo(compositeDisposable)
    }

    fun saveSurveyListIfNotEmpty(newList: List<SurveyItem>) {
        if (newList.isNotEmpty()) {
            page++
            surveyList = surveyList + newList
            getSurveyList()
        } else {
            _surveyListLiveData.value = surveyList
        }
    }

    fun setPagePosition(position: Int) {
        _pagePosition.value = position
    }

    fun slidePage() {
        _pagePosition.value = _pagePosition.value?.plus(1)
    }

    fun resetPagePosition() {
        _pagePosition.value = 0
    }

    fun reFetchSurveyList() {
        page = 1
        surveyList = emptyList()
        getSurveyList()
    }
}