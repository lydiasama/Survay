package com.lydiasama.survay.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lydiasama.survay.core.RxViewModel

class MainViewModel : RxViewModel() {
	private val _listALiveData = MutableLiveData<List<String>>()
	val listALiveData: LiveData<List<String>> = _listALiveData

}