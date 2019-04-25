package com.padcmyanmar.ecommerce_app.data.vos

import com.google.gson.annotations.SerializedName

data class SellerVO (
    @SerializedName ("seller_id") val sellerId: String,
    @SerializedName ("name") val sellerName: String,
    @SerializedName ("address") val sellerAddress: String,
    @SerializedName ("phone_no") val sellerPhoneNo: String,
    @SerializedName ("profile_image") val sellerImg: String
)