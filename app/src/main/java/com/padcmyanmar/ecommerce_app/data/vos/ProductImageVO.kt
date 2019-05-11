package com.padcmyanmar.ecommerce_app.data.vos

import com.google.gson.annotations.SerializedName

class ProductImageVO (@SerializedName("id") val id: Int,
                      @SerializedName("image_url") val imageUrl: String
)