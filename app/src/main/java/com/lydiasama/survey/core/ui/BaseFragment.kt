package com.lydiasama.survey.core.ui

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.lydiasama.survey.core.util.ViewHelper
import com.lydiasama.survey.core.util.loading.LoadingContract

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