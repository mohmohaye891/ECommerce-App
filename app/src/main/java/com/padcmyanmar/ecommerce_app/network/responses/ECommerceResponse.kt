package com.padcmyanmar.ecommerce_app.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO

class ECommerceResponse {

    @SerializedName("code")
    private val code: Int = 0

    @SerializedName("message")
    private val message: String? = null

    @SerializedName("apiVersion")
    private val apiVersion: String? = null

    @SerializedName("page")
    private val pageNo: Int = 0

    @SerializedName("mmNews")
    private var productList: List<ProductsVO>? = null

    fun getCode() : Int {
        return code
    }

    fun getMessage(): String? {
        return message
    }

    fun getApiVersion(): String? {
        return apiVersion
    }

    fun getPageNo(): Int {
        return pageNo
    }

    fun getProductList(): List<ProductsVO> {
        if (productList == null) {
            productList = ArrayList<ProductsVO>()
        }
        val productListVal = productList
        return productListVal!!
    }
}