package com.lydiasama.survey.core

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.lydiasama.survey.util.ViewHelper
import com.lydiasama.survey.util.loading.LoadingContract

@SuppressLint("Registered")
open class BaseFragment : Fragment(), LoadingContract {
    private val loadingProgressBar by lazy { ViewHelper.progressDialog() }
    override fun showLoadingView() {
        loadingProgressBar.show(childFragmentManager)
    }

    override fun hiddenLoadingView() {
        loadingProgressBar.hide(childFragmentManager)
    }
}