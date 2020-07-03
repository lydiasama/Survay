package com.lydiasama.survey.tests

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.urlMatching
import com.github.tomakehurst.wiremock.junit.WireMockRule
import com.lydiasama.survey.BuildConfig
import com.lydiasama.survey.main.MainActivity
import com.lydiasama.survey.pages.SurveyListScreen
import com.lydiasama.survey.utils.AssetReaderUtil
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class SurveyListTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java,
            true, false)

    @get:Rule
    var wireMockRule: WireMockRule = WireMockRule(BuildConfig.PORT)

    private val context = InstrumentationRegistry.getInstrumentation().context
    private val intent = MainActivity.getStartIntent(context)
            .apply { component = null }

    @Test
    fun view_survey_list() {
        val jsonBody: String = AssetReaderUtil.asset(context, "survey-list-success.json")
        wireMockRule.stubFor(get(urlMatching("/surveys.json/*"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(jsonBody)))

        val serviceEndpoint = "http://127.0.0.1:${BuildConfig.PORT}"
        Log.d("Wiremock", "WireMock Endpoint: $serviceEndpoint")

        activityRule.launchActivity(intent)

        SurveyListScreen.hasLoading()
        SurveyListScreen.hasToolbar()
        SurveyListScreen.hasSurveyList()
    }
}