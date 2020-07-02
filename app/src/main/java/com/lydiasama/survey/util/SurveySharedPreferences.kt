package com.lydiasama.survey.util

import android.content.Context

class SurveySharedPreferences(private val context: Context) : SharedPreferencesUtil {
	companion object {
		private const val SURVEY_PREFERENCE = "survey_preference"
	}

	private fun sharedPreferences() =
			context.getSharedPreferences(SURVEY_PREFERENCE, Context.MODE_PRIVATE)

	override fun getString(key: String, defaultValue: String): String {
		return sharedPreferences().getString(key, defaultValue) ?: defaultValue
	}

	override fun putString(key: String, value: String) {
		val editor = sharedPreferences().edit()
		editor.putString(key, value)
		editor.apply()
	}

	override fun remove(key: String) {
		sharedPreferences().edit()
				.remove(key)
				.apply()
	}

	override fun removeAllKeys() {
		val editor = sharedPreferences().edit()
		sharedPreferences().all.keys.forEach { editor.remove(it) }
		editor.apply()
	}
}