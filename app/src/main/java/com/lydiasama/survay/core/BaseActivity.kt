package com.lydiasama.survay.core

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import com.lydiasama.survay.util.ViewHelper
import com.lydiasama.survay.util.loading.LoadingContract

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity(), LoadingContract {
	private val loadingProgressBar by lazy { ViewHelper.progressDialog() }
	override fun showLoadingView() {
		loadingProgressBar.show(this.supportFragmentManager)
	}

	override fun hiddenLoadingView() {
		loadingProgressBar.hide(this.supportFragmentManager)
	}
}