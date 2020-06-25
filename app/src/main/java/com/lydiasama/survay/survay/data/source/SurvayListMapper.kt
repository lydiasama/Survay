package com.lydiasama.survay.survay.data.source

import android.util.Log
import com.lydiasama.survay.core.ErrorData
import com.lydiasama.survay.core.exception.RemoteException
import com.lydiasama.survay.survay.data.SurvayItem
import io.reactivex.functions.Function
import retrofit2.Response
import javax.net.ssl.HttpsURLConnection

class SurvayListMapper : Function<Response<List<SurvayItem>>, List<SurvayItem>> {
	override fun apply(response: Response<List<SurvayItem>>): List<SurvayItem> {
		return if (response.code() == HttpsURLConnection.HTTP_OK) {
			Log.d("SurvayListMapper", "body : ${response.body()
					.toString()}")
			response.body() ?: throw RemoteException(code = response.code(),
					msg = ErrorData.fromResponse(response).message)
		} else {
			throw RemoteException(code = response.code(),
					msg = ErrorData.fromResponse(response).message)
		}
	}
}