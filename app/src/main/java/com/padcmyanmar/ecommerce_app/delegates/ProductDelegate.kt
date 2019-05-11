package com.padcmyanmar.ecommerce_app.delegates

import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO

interface ProductDelegate {

    fun onSuccessProduct(data: MutableList<ProductsVO>)

    fun onFail(error:String)
}