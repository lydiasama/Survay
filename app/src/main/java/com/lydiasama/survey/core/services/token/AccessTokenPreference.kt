package com.lydiasama.survey.core.services.token

import com.lydiasama.survey.core.util.shared.preferences.SharedPreferencesUtil

class AccessTokenPreference(private val surveySharedPreferences: SharedPreferencesUtil) :
        AccessTokenDataSource {
    override fun save(token: String) {
        surveySharedPreferences.putString(ACCESS_TOKEN, token)
    }

    override fun get(): String {
        return surveySharedPreferences.getString(ACCESS_TOKEN, "")
    }

    override fun clear() {
        surveySharedPreferences.putString(ACCESS_TOKEN, "")
    }

    companion object {
        const val ACCESS_TOKEN = "ACCESS_TOKEN"
    }
}