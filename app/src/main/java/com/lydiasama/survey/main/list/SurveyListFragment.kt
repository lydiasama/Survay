package com.lydiasama.survey.main.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.lydiasama.survey.R
import com.lydiasama.survey.core.BaseFragment
import com.lydiasama.survey.core.EventObserver
import com.lydiasama.survey.main.list.adapter.SurveyListAdapter
import com.lydiasama.survey.util.dialog.DialogUtil
import com.lydiasama.survey.util.loading.LoadingDialog
import kotlinx.android.synthetic.main.fragment_survey_list.*
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class SurveyListFragment : BaseFragment() {
    private val viewModel by lifecycleScope.viewModel<SurveyListViewModel>(this)
    private val surveyListAdapter by lifecycleScope.inject<SurveyListAdapter>()
    private val dialogUtil by inject<DialogUtil>()

    private val onChangePageCallback by lazy {
        object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewModel.setPagePosition(position)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_survey_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewPager()
        initListener()
        if (childFragmentManager.findFragmentByTag(LoadingDialog.TAG) == null) {
            this.showLoadingView()
        }
        viewModel.getSurveyList()
    }

    private fun initListener() {
        toolbar?.onClickRefreshButton = {
            this.showLoadingView()
            viewModel.reFetchSurveyList()
            viewModel.resetPagePosition()
        }

        surveyButton.setOnClickListener {
            viewModel.slidePage()
        }
    }

    private fun setUpViewPager() {
        surveyPager.adapter = surveyListAdapter
        indicator.setViewPager(surveyPager)
        surveyListAdapter.registerAdapterDataObserver(indicator.adapterDataObserver)
        surveyPager.registerOnPageChangeCallback(onChangePageCallback)
    }

    override fun onDestroy() {
        surveyPager.unregisterOnPageChangeCallback(onChangePageCallback)
        super.onDestroy()
    }

    private fun observeViewModel() {
        viewModel.surveyListLiveData.observe(this, Observer {
            this.hiddenLoadingView()
            surveyListAdapter.submitList(it)
            surveyButton?.visibility = View.VISIBLE
        })

        viewModel.pagePosition.observe(this, Observer {
            surveyPager.setCurrentItem(it, true)
        })

        viewModel.errorEvent.observe(this, EventObserver {
            displayDialog()
        })
    }

    private fun displayDialog() {
        context?.let {
            dialogUtil.showDialog(
                    context = it,
                    positiveText = getString(R.string.dialog_btn_ok),
                    onPositive = {
                        this.hiddenLoadingView()
                    }
            )
        }
    }
}