package com.lydiasama.survey.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.lydiasama.survey.R
import com.lydiasama.survey.utils.isVisible

object SurveyListScreen {

    fun hasToolbar() {
        onView(withId(R.id.toolbarTitle)).check(matches(withText(R.string.survey_toolbar)))
    }

    fun hasSurveyList() {
        onView(withId(R.id.surveyPager)).perform(swipeUp())
    }

    fun hasLoading() {
        onView(withId(R.id.loadingView)).isVisible()
    }
}