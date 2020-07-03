package com.lydiasama.survey.core.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import com.lydiasama.survey.core.util.ViewHelper
import com.lydiasama.survey.core.util.loading.LoadingContract

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