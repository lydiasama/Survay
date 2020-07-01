package com.lydiasama.survey.survey.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SurveyItem(
        @SerializedName("access_code_prompt")
        val accessCodePrompt: String = "",
        @SerializedName("access_code_validation")
        val accessCodeValidation: String = "",
        @SerializedName("active_at")
        val activeAt: String = "",
        @SerializedName("cover_background_color")
        val coverBackgroundColor: String = "",
        @SerializedName("cover_image_url")
        val coverImageUrl: String = "",
        @SerializedName("created_at")
        val createdAt: String = "",
        @SerializedName("default_language")
        val defaultLanguage: String = "",
        @SerializedName("description")
        val description: String = "",
        @SerializedName("footer_content")
        val footerContent: String = "",
        @SerializedName("id")
        val id: String = "",
        @SerializedName("is_access_code_required")
        val isAccessCodeRequired: Boolean = false,
        @SerializedName("is_access_code_valid_required")
        val isAccessCodeValidRequired: Boolean = false,
        @SerializedName("language_list")
        val languageList: List<String> = listOf(),
        @SerializedName("short_url")
        val shortUrl: String = "",
        @SerializedName("survey_version")
        val surveyVersion: Int = 0,
        @SerializedName("tag_list")
        val tagList: String = "",
        @SerializedName("thank_email_above_threshold")
        val thankEmailAboveThreshold: String? = null,
        @SerializedName("thank_email_below_threshold")
        val thankEmailBelowThreshold: String? = null,
        @SerializedName("theme")
        val theme: Theme = Theme(),
        @SerializedName("title")
        val title: String = "",
        @SerializedName("type")
        val type: String = ""
) : Parcelable

@Parcelize
data class Theme(
        @SerializedName("color_active")
        val colorActive: String = "",
        @SerializedName("color_answer_inactive")
        val colorAnswerInactive: String = "",
        @SerializedName("color_answer_normal")
        val colorAnswerNormal: String = "",
        @SerializedName("color_inactive")
        val colorInactive: String = "",
        @SerializedName("color_question")
        val colorQuestion: String = ""
) : Parcelable