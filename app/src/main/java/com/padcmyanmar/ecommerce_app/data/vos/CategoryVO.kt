package com.padcmyanmar.ecommerce_app.data.vos

import com.google.gson.annotations.SerializedName

data class CategoryVO (
    @SerializedName("category_id") val  categoryId: String,
    @SerializedName("category_name") val categoryName: String
)