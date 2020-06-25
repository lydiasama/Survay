package com.lydiasama.survay.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lydiasama.survay.authentication.data.source.AuthenticationDataSource
import com.lydiasama.survay.authentication.token.AccessTokenDataSource
import com.lydiasama.survay.core.Event
import com.lydiasama.survay.core.RxViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class SplashViewModel(private val authenticationService: AuthenticationDataSource,
                      private val accessTokenDataSource: AccessTokenDataSource) : RxViewModel() {
	private val _navigateToMainActivityEvent = MutableLiveData<Event<Unit>>()
	val navigateToMainActivityEvent: LiveData<Event<Unit>> = _navigateToMainActivityEvent

	fun login() {
		authenticationService.getAccessToken()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeBy(onNext = {
					accessTokenDataSource.save(it)
					_navigateToMainActivityEvent.value = Event(Unit)
				}, onError = {
					Log.d("AUTHEN", it.message ?: "")
				})
				.addTo(compositeDisposable)
	}
}