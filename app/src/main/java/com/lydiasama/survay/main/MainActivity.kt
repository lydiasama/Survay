package com.lydiasama.survay.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.lydiasama.survay.R
import com.lydiasama.survay.core.BaseActivity
import com.lydiasama.survay.main.list.SurveyListAdapter
import com.lydiasama.survay.util.loading.LoadingDialog
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel


class MainActivity : BaseActivity() {
	private val viewModel by lifecycleScope.viewModel<MainViewModel>(this)
	private val surveyListAdapter by lifecycleScope.inject<SurveyListAdapter>()

	private val onChangePageCallback by lazy {
		object : ViewPager2.OnPageChangeCallback() {
			override fun onPageSelected(position: Int) {
				viewModel.setPagePosition(position)
			}
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		observeViewModel()
		setUpViewPager()
		initListener()
		if (supportFragmentManager.findFragmentByTag(LoadingDialog.TAG) == null) {
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
	}

	companion object {
		fun getStartIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
	}
}
