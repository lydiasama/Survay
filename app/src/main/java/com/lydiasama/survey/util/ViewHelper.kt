package com.lydiasama.survey.util

import com.lydiasama.survey.util.loading.LoadingDialog

object ViewHelper {
	fun progressDialog(): LoadingDialog =
			LoadingDialog.newInstance()
}