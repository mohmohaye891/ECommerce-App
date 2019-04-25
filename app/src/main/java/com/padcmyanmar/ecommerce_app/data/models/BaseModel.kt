package com.padcmyanmar.ecommerce_app.data.models

import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

open class BaseModel {

    @Subscribe
    fun onEvent(event : Any?) {

    }

    init {
        EventBus.getDefault().register(this)
    }

}