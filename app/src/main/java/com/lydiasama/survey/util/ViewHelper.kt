package com.lydiasama.survey.util

import android.os.Build
import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.lydiasama.survey.util.loading.LoadingDialog

object ViewHelper {
    fun progressDialog(): LoadingDialog =
            LoadingDialog.newInstance()

    @Suppress("DEPRECATION") // support old android
    fun TextView.bindHtmlText(htmlText: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            this.text = Html.fromHtml(htmlText, Html.FROM_HTML_MODE_COMPACT)
        } else {
            this.text = Html.fromHtml(htmlText)
        }
        this.movementMethod = LinkMovementMethod.getInstance()
    }

    fun ImageView.loadImage(url: String) {
        Glide.with(this)
                .load(url)
                .into(this)
    }
}