package com.lydiasama.survey.splash.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lydiasama.survey.core.services.authentication.data.source.AuthenticationDataSource
import com.lydiasama.survey.core.services.token.AccessTokenDataSource
import com.lydiasama.survey.core.ui.Event
import com.lydiasama.survey.core.ui.RxViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class SplashViewModel(private val authenticationService: AuthenticationDataSource,
                      private val accessTokenDataSource: AccessTokenDataSource) : RxViewModel() {
    private val _navigateToMainActivityEvent = MutableLiveData<Event<Unit>>()
    val navigateToMainActivityEvent: LiveData<Event<Unit>> = _navigateToMainActivityEvent

    private val _closeAppEvent = MutableLiveData<Event<Unit>>()
    val closeAppEvent: LiveData<Event<Unit>> = _closeAppEvent

    fun login() {
        authenticationService.getAccessToken()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(onNext = {
                    accessTokenDataSource.save(it)
                    _navigateToMainActivityEvent.value = Event(
                            Unit)
                }, onError = {
                    _closeAppEvent.value = Event(
                            Unit)
                })
                .addTo(compositeDisposable)
    }
}