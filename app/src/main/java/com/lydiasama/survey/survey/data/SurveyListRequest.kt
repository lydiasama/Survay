package com.lydiasama.survey.survey.data

import com.google.gson.annotations.SerializedName

data class SurveyListRequest(
		@SerializedName("page")
		val page: Int,
		@SerializedName("per_page")
		val perPage: Int
)
