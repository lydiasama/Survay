package com.lydiasama.survay.core

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.ResponseBody
import org.junit.Rule
import org.junit.rules.RuleChain
import retrofit2.Response

open class BaseTest {
	@get:Rule
	var chain = RuleChain.outerRule(RxImmediateSchedulerRule())
			.around(InstantTaskExecutorRule())

	fun <T> createErrorResponse(code: Int, data: T): Response<T> {
		val body = ResponseBody.create("".toMediaTypeOrNull(), Gson().toJson(data))
		return Response.error(code, body)
	}

	fun customResponse(code: Int, message: String): okhttp3.Response {
		return okhttp3.Response.Builder()
				.code(code)
				.message(message)
				.protocol(Protocol.HTTP_1_1)
				.request(Request.Builder()
						.url("http://localhost/")
						.build())
				.build()
	}
}