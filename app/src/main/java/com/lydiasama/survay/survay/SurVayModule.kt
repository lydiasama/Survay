package com.lydiasama.survay.survay

import com.lydiasama.survay.core.di.SubModule
import com.lydiasama.survay.survay.data.SurvayItem
import com.lydiasama.survay.survay.data.source.SurvayListApi
import com.lydiasama.survay.survay.data.source.SurvayListDataSource
import com.lydiasama.survay.survay.data.source.SurvayListMapper
import com.lydiasama.survay.survay.data.source.SurvayListService
import io.reactivex.functions.Function
import org.koin.dsl.ScopeDSL
import retrofit2.Response
import retrofit2.Retrofit

val survayListDataSourceModule = object : SubModule {
	override fun invoke(scopeDsl: ScopeDSL) {
		scopeDsl.scoped<SurvayListApi> {
			get<Retrofit>().create(SurvayListApi::class.java)
		}
		scopeDsl.scoped<Function<Response<List<SurvayItem>>, List<SurvayItem>>> { SurvayListMapper() }
		scopeDsl.scoped<SurvayListDataSource> { SurvayListService(get(), get()) }
	}
}