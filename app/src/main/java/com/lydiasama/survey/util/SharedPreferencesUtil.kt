package com.lydiasama.survey.util

interface SharedPreferencesUtil {
	fun getString(key: String, defaultValue: String = ""): String
	fun putString(key: String, value: String)
	fun remove(key: String)
	fun removeAllKeys()
}