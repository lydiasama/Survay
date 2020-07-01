package com.lydiasama.survey.main.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.lydiasama.survey.survey.data.SurveyItem

class SurveyListAdapter : ListAdapter<SurveyItem, SurveyListViewHolder>(SurveyListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurveyListViewHolder {
        return SurveyListViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: SurveyListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}