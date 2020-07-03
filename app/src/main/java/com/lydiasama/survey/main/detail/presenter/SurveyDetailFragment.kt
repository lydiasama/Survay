package com.lydiasama.survey.main.detail.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lydiasama.survey.R
import com.lydiasama.survey.core.ui.BaseFragment
import com.lydiasama.survey.core.util.ViewHelper.bindHtmlText
import com.lydiasama.survey.core.util.ViewHelper.loadImage
import kotlinx.android.synthetic.main.fragment_survey_detail.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class SurveyDetailFragment : BaseFragment() {
    private val viewModel by lifecycleScope.viewModel<SurveyDetailViewModel>(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            viewModel.surveyItem = SurveyDetailFragmentArgs.fromBundle(
                    it).surveyItem
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_survey_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        coverImage.loadImage(viewModel.surveyItem.coverImageUrl)
        titleText.text = viewModel.surveyItem.title
        descriptionText.text = viewModel.surveyItem.description

        viewModel.surveyItem.thankEmailAboveThreshold?.let {
            thankEmailAboveThresholdText.bindHtmlText(it)
        } ?: kotlin.run {
            thankEmailAboveThresholdText.visibility = View.GONE
        }
    }
}