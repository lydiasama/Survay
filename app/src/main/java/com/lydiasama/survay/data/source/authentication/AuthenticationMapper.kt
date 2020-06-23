package com.lydiasama.survay.data.source.authentication

import android.util.Log
import com.lydiasama.survay.data.AuthenticationResult
import com.lydiasama.survay.data.ErrorData
import com.lydiasama.survay.exception.RemoteException
import io.reactivex.functions.Function
import retrofit2.Response

class AuthenticationMapper : Function<Response<AuthenticationResult>, AuthenticationResult> {
	override fun apply(response: Response<AuthenticationResult>?): AuthenticationResult {
		return response?.let {
			if (it.isSuccessful) {
				Log.d("AuthenticationMapper", it.toString())
				Log.d("AuthenticationMapper", "body : ${it.body()
						.toString()}")
				it.body()
			} else {
				throw RemoteException(code = it.code(),
						msg = ErrorData.fromResponse(response).message)
			}
		} ?: AuthenticationResult()
	}
}