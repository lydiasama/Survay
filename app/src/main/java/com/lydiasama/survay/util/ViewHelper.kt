package com.lydiasama.survay.util

import com.lydiasama.survay.util.loading.LoadingDialog

object ViewHelper {
	fun progressDialog(): LoadingDialog =
			LoadingDialog.newInstance()
}