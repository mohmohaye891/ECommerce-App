package com.padcmyanmar.ecommerce_app.mvp.presenters

abstract class BasePresenter<T>(val mView : T) {
    fun onCreate(){}
    abstract fun onStart()
    abstract fun onStop()
    fun onDestroyed(){}
}