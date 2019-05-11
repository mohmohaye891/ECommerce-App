package com.padcmyanmar.ecommerce_app.network

import com.google.gson.Gson
import com.padcmyanmar.ecommerce_app.delegates.CategoryResponseDelegate
import com.padcmyanmar.ecommerce_app.delegates.ProductResponseDelegate
import com.padcmyanmar.ecommerce_app.network.responses.ECCategoryResponse
import com.padcmyanmar.ecommerce_app.network.responses.ECProductResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ECommerceDataAgent {

    private val mEcommerceApi: ECommerceApi


    fun loadCategory(accessToken: String, page: Int, delegate: CategoryResponseDelegate) {
        val categoryResponseCall = mEcommerceApi.loadCategory(page, accessToken)
        categoryResponseCall.enqueue(object : Callback<ECCategoryResponse> {
            override fun onFailure(call: Call<ECCategoryResponse>, t: Throwable) {
                delegate.onFail(t.localizedMessage)
            }

            override fun onResponse(call: Call<ECCategoryResponse>, response: Response<ECCategoryResponse>) {
                val categoryResponse: ECCategoryResponse? = response.body()
                if (categoryResponse != null
                    && categoryResponse.code == 200
                    && categoryResponse.categoryList.isNotEmpty()
                ) {
                    delegate.onSuccess(categoryResponse.categoryList)
                } else {
                    if (categoryResponse != null)
                        delegate.onFail(categoryResponse.message)
                    else
                        delegate.onFail("Empty Api")
                }

            }
        })
    }

    fun loadProduct(accessToken: String, page: Int, delegate: ProductResponseDelegate) {
        val productResponseCall = mEcommerceApi.loadProduct(page, accessToken)
        productResponseCall.enqueue(object : Callback<ECProductResponse> {
            override fun onFailure(call: Call<ECProductResponse>, t: Throwable) {
                delegate.onFail(t.localizedMessage)
            }

            override fun onResponse(call: Call<ECProductResponse>, response: Response<ECProductResponse>) {
                val productResponse: ECProductResponse? = response.body()
                if (productResponse != null
                    && productResponse.code == 200
                    && productResponse.productList.isNotEmpty()
                ) {
                    delegate.onSuccess(productResponse.productList)
                } else {
                    if (productResponse != null)
                        delegate.onFail(productResponse.message)
                    else
                        delegate.onFail("Empty Api")
                }

            }
        })
    }

    fun loadProductById(accessToken: String, page: Int, delegate: ProductResponseDelegate) {
        val  productResponseCall = mEcommerceApi.loadProduct(page, accessToken)
        productResponseCall.enqueue(object : Callback<ECProductResponse> {
            override fun onFailure(call: Call<ECProductResponse>, t: Throwable) {
                delegate.onFail(t.localizedMessage)
            }

            override fun onResponse(call: Call<ECProductResponse>, response: Response<ECProductResponse>) {
               val productResponse: ECProductResponse? = response.body()
                if (productResponse != null
                    && productResponse.code== 200
                    && productResponse.productList.isNotEmpty()
                ) {
                    delegate.onSuccess(productResponse.productList)
                }else{
                    if (productResponse != null)
                        delegate.onFail(productResponse.message)

                    else
                        delegate.onFail("")
                }
            }

        })
    }


    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://padcmyanmar.com/padc-3/final-projects/e-commerce/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClient)
            .build()
        mEcommerceApi = retrofit.create(ECommerceApi::class.java)
    }

}