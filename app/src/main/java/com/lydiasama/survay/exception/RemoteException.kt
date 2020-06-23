package com.lydiasama.survay.exception

data class RemoteException(val code: Int = 500, val msg: String? = "") : Throwable(message = msg)