package com.lydiasama.survay.survey.data

import com.google.gson.annotations.SerializedName

data class SurveyItem(
		@SerializedName("cover_image_url")
		val coverImageUrl: String = "",
		@SerializedName("description")
		val description: String = "",
		@SerializedName("id")
		val id: String = "",
		@SerializedName("title")
		val title: String = ""
)