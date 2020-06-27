package com.lydiasama.survay.util.loading

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.lydiasama.survay.R

class LoadingDialog @SuppressLint("ValidFragment") constructor
() : DialogFragment() {
	override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
		return context?.let { Dialog(it) }
				?.apply {
					requestWindowFeature(Window.FEATURE_NO_TITLE)
					window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
					setContentView(R.layout.view_loading)
					isCancelable = false
					setCancelable(false)
				} ?: super.onCreateDialog(savedInstanceState)
	}

	fun show(manager: FragmentManager) {
		synchronized(this) {
			if (isAdded.not()) {
				val fragmentTransaction = manager.beginTransaction()
				fragmentTransaction.add(this,
						TAG)
				fragmentTransaction.commitNowAllowingStateLoss()
			}
		}
	}

	fun hide(manager: FragmentManager) {
		if (isAdded) {
			(manager.findFragmentByTag(
					TAG) as? LoadingDialog)?.dismissAllowingStateLoss()
		}
	}

	companion object {
		const val TAG = "co.component.loading.dialog"
		fun newInstance(): LoadingDialog =
				LoadingDialog()
	}
}