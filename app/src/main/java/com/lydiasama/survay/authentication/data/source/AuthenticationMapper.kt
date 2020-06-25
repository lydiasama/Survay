package com.lydiasama.survay.authentication.data.source

import android.util.Log
import com.lydiasama.survay.authentication.data.AuthenticationResult
import com.lydiasama.survay.core.ErrorData
import com.lydiasama.survay.core.exception.RemoteException
import io.reactivex.functions.Function
import retrofit2.Response
import javax.net.ssl.HttpsURLConnection

class AuthenticationMapper : Function<Response<AuthenticationResult>, AuthenticationResult> {
	override fun apply(response: Response<AuthenticationResult>): AuthenticationResult {
		Log.d("AuthenticationMapper", response.toString())
		return if (response.code() == HttpsURLConnection.HTTP_OK) {
			Log.d("AuthenticationMapper", "body : ${response.body()
					.toString()}")
			response.body() ?: throw RemoteException(code = response.code(),
					msg = ErrorData.fromResponse(response).message)
		} else {
			throw RemoteException(code = response.code(),
					msg = ErrorData.fromResponse(response).message)
		}
	}
}