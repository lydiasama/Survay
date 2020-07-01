package com.lydiasama.survey.core

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import com.lydiasama.survey.util.ViewHelper
import com.lydiasama.survey.util.loading.LoadingContract

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