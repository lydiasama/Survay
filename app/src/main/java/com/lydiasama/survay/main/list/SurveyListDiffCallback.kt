package com.lydiasama.survay.main.list

import androidx.recyclerview.widget.DiffUtil
import com.lydiasama.survay.survey.data.SurveyItem

class SurveyListDiffCallback : DiffUtil.ItemCallback<SurveyItem>() {
	override fun areItemsTheSame(oldItem: SurveyItem, newItem: SurveyItem): Boolean {
		return oldItem.id == newItem.id
	}

	override fun areContentsTheSame(oldItem: SurveyItem, newItem: SurveyItem): Boolean {
		return oldItem == newItem
	}
}
