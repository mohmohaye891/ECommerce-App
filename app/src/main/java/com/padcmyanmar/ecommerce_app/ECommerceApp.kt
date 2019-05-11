package com.padcmyanmar.ecommerce_app

import android.app.Application
import com.padcmyanmar.ecommerce_app.data.models.ECommerceAppModel

class ECommerceApp : Application() {

    companion object {
        const val TAG = "ECommerceApp"
    }

    override fun onCreate() {
        super.onCreate()
        ECommerceAppModel.initDataBase(applicationContext)
    }

}