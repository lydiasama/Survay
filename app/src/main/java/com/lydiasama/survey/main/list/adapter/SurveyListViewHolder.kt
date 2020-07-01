package com.lydiasama.survey.main.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lydiasama.survey.R
import com.lydiasama.survey.survey.data.SurveyItem
import com.lydiasama.survey.util.ViewHelper.loadImage
import kotlinx.android.synthetic.main.item_survey.view.*

class SurveyListViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(surveyItem: SurveyItem) {
        itemView.titleText.text = surveyItem.title
        itemView.descriptionText.text = surveyItem.description
        itemView.surveyImage.loadImage(surveyItem.coverImageUrl.plus("l"))
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
