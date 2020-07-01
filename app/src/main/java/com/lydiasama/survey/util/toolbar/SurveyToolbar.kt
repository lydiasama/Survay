package com.lydiasama.survey.util.toolbar

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.lydiasama.survey.R
import kotlinx.android.synthetic.main.view_toolbar.view.*

class SurveyToolbar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                              defStyleAttr: Int = 0) :
        LinearLayout(context, attrs, defStyleAttr) {

    var onClickRefreshButton: (() -> Unit)? = null

    init {
        inflate(context, R.layout.view_toolbar, this)

        attrs?.let {
            processAttributes(context, it)
        }

        setOnClickRefreshButton()
    }

    private fun setOnClickRefreshButton() {
        toolbarLeftButton.setOnClickListener { onClickRefreshButton?.invoke() }
    }

    private fun processAttributes(context: Context, attrs: AttributeSet?) {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.SurveyToolbar)
        toolbarTitle.text = attributes.getString(
                R.styleable.SurveyToolbar_title) ?: ""

        attributes.recycle()
    }

}