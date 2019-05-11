package com.padcmyanmar.ecommerce_app.delegates

import com.padcmyanmar.ecommerce_app.data.vos.CategoryVO

interface CategoryDelegate {

    fun onSuccessCategory(data : MutableList<CategoryVO>)

    fun onFail(error : String)
}