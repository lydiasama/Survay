package com.lydiasama.survey.main.list

import com.lydiasama.survey.core.BaseTest
import com.lydiasama.survey.survey.data.SurveyItem
import com.lydiasama.survey.survey.data.source.SurveyListDataSource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SurveyListViewModelTest : BaseTest() {
    private lateinit var viewModel: SurveyListViewModel

    @Mock
    lateinit var surveyListService: SurveyListDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = SurveyListViewModel(surveyListService)
    }

    @Test
    fun `getSurveyList should return survey list when success`() {
        val surveyList = listOf(SurveyItem(
                coverImageUrl = "mockCoverImg",
                title = "title",
                description = "description"))
        whenever(surveyListService.getSurveyList(1)) doReturn Observable.just(surveyList)
        whenever(surveyListService.getSurveyList(2)) doReturn Observable.empty()

        viewModel.getSurveyList()

        verify(surveyListService, times(2)).getSurveyList(any())
    }

    @Test
    fun `saveSurveyListIfNotEmpty should process to call next page when result is not empty`() {
        val surveyList = listOf(SurveyItem(
                coverImageUrl = "mockCoverImg",
                title = "title",
                description = "description"))
        whenever(surveyListService.getSurveyList(2)) doReturn Observable.empty()

        viewModel.saveSurveyListIfNotEmpty(surveyList)

        Assert.assertEquals(2, viewModel.page)
        Assert.assertEquals(surveyList, viewModel.surveyList)
        verify(surveyListService).getSurveyList(any())
    }

    @Test
    fun `saveSurveyListIfNotEmpty should increase page and survey list when result is more than one`() {
        val surveyList1 = listOf(
                SurveyItem(
                        coverImageUrl = "1",
                        title = "1",
                        description = "1"))
        val surveyList2 = listOf(
                SurveyItem(
                        coverImageUrl = "2",
                        title = "2",
                        description = "2"),
                SurveyItem(
                        coverImageUrl = "3",
                        title = "3",
                        description = "3"))
        val expectSurveyList = surveyList1 + surveyList2
        whenever(surveyListService.getSurveyList(2)) doReturn Observable.just(surveyList2)
        whenever(surveyListService.getSurveyList(3)) doReturn Observable.empty()

        viewModel.saveSurveyListIfNotEmpty(surveyList1)

        Assert.assertEquals(3, viewModel.page)
        Assert.assertEquals(expectSurveyList, viewModel.surveyList)
    }

    @Test
    fun `saveSurveyListIfNotEmpty should not call service when result is empty`() {
        val surveyList = listOf(
                SurveyItem(
                        coverImageUrl = "1",
                        title = "1",
                        description = "1"))
        whenever(surveyListService.getSurveyList(2)) doReturn Observable.empty()

        viewModel.saveSurveyListIfNotEmpty(surveyList)

        verify(surveyListService, never()).getSurveyList(3)
    }

    @Test
    fun `setPagePosition should set pagePosition with paramiter`() {
        val pagePosition = 4
        viewModel.setPagePosition(pagePosition)

        Assert.assertEquals(pagePosition, viewModel.pagePosition.value)
    }

    @Test
    fun `slidePage should increase pagePosition`() {
        viewModel.slidePage()

        Assert.assertEquals(1, viewModel.pagePosition.value)
    }

    @Test
    fun `resetPagePosition should reset pagePosition to 0`() {
        viewModel.resetPagePosition()

        Assert.assertEquals(0, viewModel.pagePosition.value)
    }

    @Captor
    lateinit var acPage: ArgumentCaptor<Int>

    @Test
    fun `reFetchSurveyList should reset page before re-fetch list`() {
        val surveyList = listOf(SurveyItem(
                coverImageUrl = "mockCoverImg",
                title = "title",
                description = "description"))
        whenever(surveyListService.getSurveyList(1)) doReturn Observable.just(surveyList)
        whenever(surveyListService.getSurveyList(2)) doReturn Observable.empty()

        viewModel.reFetchSurveyList()

        verify(surveyListService, times(2)).getSurveyList(acPage.capture())
        val capturedPage: List<Int> = acPage.allValues
        Assert.assertEquals(1, capturedPage[0])
    }
}