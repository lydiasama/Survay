package com.lydiasama.survay.util.dialog

import android.app.AlertDialog
import android.content.Context
import com.lydiasama.survay.R

interface DialogUtil {
	fun showDialog(context: Context,
	               title: String = context.getString(R.string.dialog_title),
	               message: String = context.getString(R.string.dialog_default_message_error),
	               positiveText: String,
	               onPositive: (() -> Unit)?): AlertDialog
}