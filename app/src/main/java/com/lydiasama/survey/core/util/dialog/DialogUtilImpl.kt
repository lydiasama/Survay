package com.lydiasama.survey.core.util.dialog

import android.app.AlertDialog
import android.content.Context
import com.lydiasama.survey.R

object DialogUtilImpl : DialogUtil {
    override fun showDialog(context: Context, title: String, message: String, positiveText: String,
                            onPositive: (() -> Unit)?): AlertDialog {
        val builder = AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.dialog_btn_ok) { dialog, _ ->
                    onPositive?.invoke()
                    dialog.dismiss()
                }
        val alert = builder.create()
        alert.show()
        return alert
    }
}