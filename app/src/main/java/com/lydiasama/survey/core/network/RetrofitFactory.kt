package com.lydiasama.survey.core.network

import com.google.gson.GsonBuilder
import com.lydiasama.survey.BuildConfig.BASE_URL
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val gsonBuilder = GsonBuilder().setLenient()
        val gson = gsonBuilder.create()
        val gsonConverterFactory = GsonConverterFactory.create(gson)
        val rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.createWithScheduler(
                Schedulers.io())
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .client(okHttpClient)
                .build()
    }

    fun createRetrofitWithOutInterceptor(): Retrofit {
        val gsonBuilder = GsonBuilder().setLenient()
        val gson = gsonBuilder.create()
        val gsonConverterFactory = GsonConverterFactory.create(gson)
        val rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.createWithScheduler(
                Schedulers.io())
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build()
    }
}