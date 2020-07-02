package com.lydiasama.survey.core.module

import com.lydiasama.survey.authentication.data.AuthenticationResult
import com.lydiasama.survey.authentication.data.source.AuthenticationApi
import com.lydiasama.survey.authentication.data.source.AuthenticationDataSource
import com.lydiasama.survey.authentication.data.source.AuthenticationMapper
import com.lydiasama.survey.authentication.data.source.AuthenticationService
import com.lydiasama.survey.authentication.data.source.token.AccessTokenDataSource
import com.lydiasama.survey.authentication.data.source.token.AccessTokenPreference
import com.lydiasama.survey.core.network.OkHttpClientFactory
import com.lydiasama.survey.core.network.RetrofitFactory
import com.lydiasama.survey.core.network.TokenAuthenticator
import com.lydiasama.survey.core.network.TokenInterceptor
import com.lydiasama.survey.util.SharedPreferencesUtil
import com.lydiasama.survey.util.SurveySharedPreferences
import io.reactivex.functions.Function
import okhttp3.Authenticator
import okhttp3.Interceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Response

val networkModule = module {
    factory<AuthenticationApi> {
        RetrofitFactory.createRetrofitWithOutInterceptor()
                .create(AuthenticationApi::class.java)
    }
    factory<Function<Response<AuthenticationResult>, AuthenticationResult>> { AuthenticationMapper() }
    factory<AccessTokenDataSource> { AccessTokenPreference(get()) }
    factory<AuthenticationDataSource> {
        AuthenticationService(get(), get(), get())
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