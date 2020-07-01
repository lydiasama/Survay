package com.lydiasama.survey.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.lydiasama.survey.R
import com.lydiasama.survey.core.BaseActivity


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
    }
}
