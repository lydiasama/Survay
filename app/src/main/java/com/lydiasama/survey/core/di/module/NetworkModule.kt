package com.lydiasama.survey.core.di.module

import com.lydiasama.survey.core.di.SubModule
import com.lydiasama.survey.core.network.OkHttpClientFactory
import com.lydiasama.survey.core.network.RetrofitFactory
import com.lydiasama.survey.core.network.TokenAuthenticator
import com.lydiasama.survey.core.network.TokenInterceptor
import com.lydiasama.survey.core.services.authentication.data.AuthenticationResult
import com.lydiasama.survey.core.services.authentication.data.source.AuthenticationApi
import com.lydiasama.survey.core.services.authentication.data.source.AuthenticationDataSource
import com.lydiasama.survey.core.services.authentication.data.source.AuthenticationMapper
import com.lydiasama.survey.core.services.authentication.AuthenticationService
import com.lydiasama.survey.core.services.token.AccessTokenDataSource
import com.lydiasama.survey.core.services.token.AccessTokenPreference
import com.lydiasama.survey.main.list.data.SurveyItem
import com.lydiasama.survey.main.list.data.source.SurveyListApi
import com.lydiasama.survey.main.list.data.source.SurveyListDataSource
import com.lydiasama.survey.main.list.data.source.SurveyListMapper
import com.lydiasama.survey.main.list.services.SurveyListService
import io.reactivex.functions.Function
import okhttp3.Authenticator
import okhttp3.Interceptor
import org.koin.dsl.ScopeDSL
import org.koin.dsl.module
import retrofit2.Response
import retrofit2.Retrofit

val networkModule = module {
    factory<AuthenticationApi> {
        RetrofitFactory.createRetrofitWithOutInterceptor()
                .create(AuthenticationApi::class.java)
    }
    factory<Function<Response<AuthenticationResult>, AuthenticationResult>> { AuthenticationMapper() }
    factory<AccessTokenDataSource> { AccessTokenPreference(get()) }
    factory<AuthenticationDataSource> {
        AuthenticationService(
                get(), get(), get())
    }
    factory<Authenticator> { TokenAuthenticator(get(), get()) }
    factory<Interceptor> { TokenInterceptor(get()) }
    factory {
        OkHttpClientFactory(get(), get()).createOkHttpClient()
    }
    single {
        RetrofitFactory.createRetrofit(get())
    }
}

val authenticationDataSourceModule = object : SubModule {
    override fun invoke(scopeDsl: ScopeDSL) {
        scopeDsl.scoped<AuthenticationApi> {
            get<Retrofit>().create(AuthenticationApi::class.java)
        }
        scopeDsl.scoped<Function<Response<AuthenticationResult>, AuthenticationResult>> { AuthenticationMapper() }
        scopeDsl.scoped<AuthenticationDataSource> {
            AuthenticationService(
                    get(), get(), get())
        }
    }
}

val surveyListDataSourceModule = object : SubModule {
    override fun invoke(scopeDsl: ScopeDSL) {
        scopeDsl.scoped<SurveyListApi> {
            get<Retrofit>().create(SurveyListApi::class.java)
        }
        scopeDsl.scoped<Function<Response<List<SurveyItem>>, List<SurveyItem>>> { SurveyListMapper() }
        scopeDsl.scoped<SurveyListDataSource> {
            SurveyListService(get(),
                    get())
        }
    }
}