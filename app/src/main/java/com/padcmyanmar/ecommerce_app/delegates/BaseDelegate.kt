package com.padcmyanmar.ecommerce_app.delegates

interface BaseDelegate<D> {
    fun onSuccess(dataVO : D)
    fun onFail(message : String)

}