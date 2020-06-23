package com.lydiasama.survay.data

import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lydiasama.survay.exception.RemoteException
import okhttp3.Response

data class ErrorData(@Expose val httpCode: Int = 500,
                     @SerializedName("code") val errorCode: String = "",
                     @SerializedName("message") val message: String = "") {
	companion object {

		fun fromResponse(response: Response): ErrorData = response.body
				?.let { Gson().fromJson(it.string(), ErrorData::class.java) }
				?.let { errorData ->
					ErrorData(httpCode = response.code, message = response.message,
							errorCode = errorData.errorCode)
				}
				?: ErrorData(httpCode = response.code, message = "Something went wrong",
						errorCode = "500")

		fun <T> fromResponse(response: retrofit2.Response<T>): ErrorData = try {
			response.errorBody()
					?.let { Gson().fromJson(it.string(), ErrorData::class.java) }
					?.let { errorData ->
						ErrorData(httpCode = response.code(), message = errorData.message,
								errorCode = errorData.errorCode)
					} ?: ErrorData(httpCode = response.code(), message = "Something went wrong",
					errorCode = "500")
		} catch (e: Exception) {
			e.printStackTrace()
			throw RemoteException(msg = null)
		}
	}
}