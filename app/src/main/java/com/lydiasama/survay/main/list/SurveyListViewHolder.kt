package com.lydiasama.survay.main.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lydiasama.survay.R
import com.lydiasama.survay.survey.data.SurveyItem
import kotlinx.android.synthetic.main.item_survey.view.*

class SurveyListViewHolder private constructor(view: View) :
		RecyclerView.ViewHolder(view) {
	fun bind(surveyItem: SurveyItem) {
		itemView.titleText.text = surveyItem.title
		itemView.descriptionText.text = surveyItem.description

		Glide.with(itemView)
				.load(surveyItem.coverImageUrl.plus("l"))
				.into(itemView.surveyImage)
	}

	companion object {
		fun newInstance(parent: ViewGroup): SurveyListViewHolder {
			return SurveyListViewHolder(
					LayoutInflater.from(parent.context)
							.inflate(R.layout.item_survey, parent,
									false))
		}
	}
}
