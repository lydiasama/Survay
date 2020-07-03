package com.lydiasama.survey.core.util.shared.preferences

interface SharedPreferencesUtil {
	fun getString(key: String, defaultValue: String = ""): String
	fun putString(key: String, value: String)
	fun remove(key: String)
	fun removeAllKeys()
}