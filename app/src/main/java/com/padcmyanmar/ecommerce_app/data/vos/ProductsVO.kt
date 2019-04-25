package com.padcmyanmar.ecommerce_app.data.vos

import com.google.gson.annotations.SerializedName

open class ProductsVO(productId: String = "",
                      productName: String = "",
                      productImages : List<String> = ArrayList(),
                      productDescription: String = "",
                      productPrice: String = "",
                      category: List<CategoryVO> = ArrayList(),
                      uploadedTime: String = "",
                      uploadedDate: String = "",
                      seller: SellerVO? = null,
                      availability: Boolean = false
                      ) {
    @SerializedName("product_id")
    open var productId: String = productId

    @SerializedName("product_name")
    var productName: String = productName

    @SerializedName("product_image_url")
    var productImages: List<String>? = productImages
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("product_desc")
    var productDescription: String = productDescription

    @SerializedName("product_price")
    var productPrice: String = productPrice

    @SerializedName("category")
    var category: List<CategoryVO>? = category
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("uploaded_time")
    var uploadedTime: String = uploadedTime

    @SerializedName("uploaded_date")
    var uploadedDate: String = uploadedDate

    @SerializedName("seller")
    var seller: SellerVO? = seller

    @SerializedName("availability")
    var availability: Boolean = availability

}