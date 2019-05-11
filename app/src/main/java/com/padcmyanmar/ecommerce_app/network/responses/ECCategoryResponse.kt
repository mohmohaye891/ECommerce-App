package com.padcmyanmar.ecommerce_app.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.ecommerce_app.data.vos.CategoryVO

class ECCategoryResponse (
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("apiVersion") val apiVersion: String,
    @SerializedName("page") val pageNo: String,
    @SerializedName("categoryList") val categoryList: MutableList<CategoryVO>
)
