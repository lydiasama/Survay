package com.lydiasama.survey.survey

import com.lydiasama.survey.core.di.SubModule
import com.lydiasama.survey.survey.data.SurveyItem
import com.lydiasama.survey.survey.data.source.SurveyListApi
import com.lydiasama.survey.survey.data.source.SurveyListDataSource
import com.lydiasama.survey.survey.data.source.SurveyListMapper
import com.lydiasama.survey.survey.data.source.SurveyListService
import io.reactivex.functions.Function
import org.koin.dsl.ScopeDSL
import retrofit2.Response
import retrofit2.Retrofit

val surveyListDataSourceModule = object : SubModule {
    override fun invoke(scopeDsl: ScopeDSL) {
        scopeDsl.scoped<SurveyListApi> {
            get<Retrofit>().create(SurveyListApi::class.java)
        }
        scopeDsl.scoped<Function<Response<List<SurveyItem>>, List<SurveyItem>>> { SurveyListMapper() }
        scopeDsl.scoped<SurveyListDataSource> { SurveyListService(get(), get()) }
    }
}