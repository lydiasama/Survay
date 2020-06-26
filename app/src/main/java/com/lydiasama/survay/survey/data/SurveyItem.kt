package com.lydiasama.survay.survey.data

import com.google.gson.annotations.SerializedName

data class SurveyItem(
		@SerializedName("access_code_prompt")
		val accessCodePrompt: Any = Any(),
		@SerializedName("access_code_validation")
		val accessCodeValidation: String = "",
		@SerializedName("active_at")
		val activeAt: String = "",
		@SerializedName("cover_background_color")
		val coverBackgroundColor: Any = Any(),
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
		@SerializedName("inactive_at")
		val inactiveAt: Any = Any(),
		@SerializedName("is_access_code_required")
		val isAccessCodeRequired: Boolean = false,
		@SerializedName("is_access_code_valid_required")
		val isAccessCodeValidRequired: Boolean = false,
		@SerializedName("is_active")
		val isActive: Boolean = false,
		@SerializedName("language_list")
		val languageList: List<String> = listOf(),
		@SerializedName("questions")
		val questions: List<Question> = listOf(),
		@SerializedName("short_url")
		val shortUrl: String = "",
		@SerializedName("survey_version")
		val surveyVersion: Int = 0,
		@SerializedName("tag_list")
		val tagList: String = "",
		@SerializedName("thank_email_above_threshold")
		val thankEmailAboveThreshold: String = "",
		@SerializedName("thank_email_below_threshold")
		val thankEmailBelowThreshold: String = "",
		@SerializedName("theme")
		val theme: Theme = Theme(),
		@SerializedName("title")
		val title: String = "",
		@SerializedName("type")
		val type: String = ""
)

data class Question(
		@SerializedName("answers")
		val answers: List<Answer> = listOf(),
		@SerializedName("correct_answer_id")
		val correctAnswerId: Any = Any(),
		@SerializedName("cover_background_color")
		val coverBackgroundColor: Any = Any(),
		@SerializedName("cover_image_opacity")
		val coverImageOpacity: Double = 0.0,
		@SerializedName("cover_image_url")
		val coverImageUrl: String = "",
		@SerializedName("display_order")
		val displayOrder: Int = 0,
		@SerializedName("display_type")
		val displayType: String = "",
		@SerializedName("facebook_profile")
		val facebookProfile: Any = Any(),
		@SerializedName("font_face")
		val fontFace: Any = Any(),
		@SerializedName("font_size")
		val fontSize: Any = Any(),
		@SerializedName("help_text")
		val helpText: Any = Any(),
		@SerializedName("id")
		val id: String = "",
		@SerializedName("image_url")
		val imageUrl: String = "",
		@SerializedName("is_mandatory")
		val isMandatory: Boolean = false,
		@SerializedName("is_shareable_on_facebook")
		val isShareableOnFacebook: Boolean = false,
		@SerializedName("is_shareable_on_twitter")
		val isShareableOnTwitter: Boolean = false,
		@SerializedName("pick")
		val pick: String = "",
		@SerializedName("short_text")
		val shortText: String = "",
		@SerializedName("tag_list")
		val tagList: String = "",
		@SerializedName("text")
		val text: String = "",
		@SerializedName("twitter_profile")
		val twitterProfile: Any = Any()
)

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
)

data class Answer(
		@SerializedName("alerts")
		val alerts: List<Any> = listOf(),
		@SerializedName("date_constraint")
		val dateConstraint: Any = Any(),
		@SerializedName("default_value")
		val defaultValue: Any = Any(),
		@SerializedName("display_order")
		val displayOrder: Int = 0,
		@SerializedName("display_type")
		val displayType: String = "",
		@SerializedName("help_text")
		val helpText: Any = Any(),
		@SerializedName("id")
		val id: String = "",
		@SerializedName("input_mask")
		val inputMask: Any = Any(),
		@SerializedName("input_mask_placeholder")
		val inputMaskPlaceholder: Any = Any(),
		@SerializedName("is_customer_email")
		val isCustomerEmail: Boolean = false,
		@SerializedName("is_customer_first_name")
		val isCustomerFirstName: Boolean = false,
		@SerializedName("is_customer_last_name")
		val isCustomerLastName: Boolean = false,
		@SerializedName("is_customer_title")
		val isCustomerTitle: Boolean = false,
		@SerializedName("is_mandatory")
		val isMandatory: Boolean = false,
		@SerializedName("prompt_custom_answer")
		val promptCustomAnswer: Boolean = false,
		@SerializedName("question_id")
		val questionId: String = "",
		@SerializedName("reference_identifier")
		val referenceIdentifier: Any = Any(),
		@SerializedName("response_class")
		val responseClass: String = "",
		@SerializedName("score")
		val score: Any = Any(),
		@SerializedName("short_text")
		val shortText: String = "",
		@SerializedName("text")
		val text: String = "",
		@SerializedName("weight")
		val weight: Any = Any()
)