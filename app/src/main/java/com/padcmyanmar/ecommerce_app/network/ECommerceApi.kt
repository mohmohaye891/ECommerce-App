package com.padcmyanmar.ecommerce_app.network


import com.padcmyanmar.ecommerce_app.network.responses.ECCategoryResponse
import com.padcmyanmar.ecommerce_app.network.responses.ECProductResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ECommerceApi {

    @FormUrlEncoded
    @POST("fun/getCategory.php")
    fun loadCategory(
        @Field("page") pageIndex: Int,
        @Field("access_token") accessToken: String) : Call<ECCategoryResponse>

    @FormUrlEncoded
    @POST("fun/getProducts.php")
    fun loadProduct(
        @Field("page") pageIndex: Int,
        @Field("access_token") accessToken: String) : Call<ECProductResponse>
}