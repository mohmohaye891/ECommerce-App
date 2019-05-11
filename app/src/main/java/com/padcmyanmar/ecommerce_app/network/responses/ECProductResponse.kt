package com.padcmyanmar.ecommerce_app.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO

open class ECProductResponse (
    @SerializedName("code") val code: Int = 0,
    @SerializedName("message") val message: String,
    @SerializedName("apiVersion")val apiVersion: String,
    @SerializedName("page") val pageNo: String,
    @SerializedName("products") val productList : MutableList<ProductsVO>
) {
    fun isResponseSuccess(): Boolean {
        return code == 200 && !productList.isEmpty()
    }
}
