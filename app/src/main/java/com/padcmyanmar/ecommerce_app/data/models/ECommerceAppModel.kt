package com.padcmyanmar.ecommerce_app.data.models

import android.content.Context
import android.util.Log
import com.padcmyanmar.ecommerce_app.ECommerceApp
import com.padcmyanmar.ecommerce_app.data.vos.CategoryVO
import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO
import com.padcmyanmar.ecommerce_app.delegates.CategoryDelegate
import com.padcmyanmar.ecommerce_app.delegates.CategoryResponseDelegate
import com.padcmyanmar.ecommerce_app.delegates.ProductDelegate
import com.padcmyanmar.ecommerce_app.delegates.ProductResponseDelegate
import com.padcmyanmar.ecommerce_app.network.ECommerceDataAgent
import com.padcmyanmar.ecommerce_app.persistance.ECommerceDB
import com.padcmyanmar.ecommerce_app.utils.AppConstants

object ECommerceAppModel : BaseModel(){

    private var mProductPage: Int = 1
    private var mCategoryPage: Int = 1

   private lateinit var mTheDB : ECommerceDB

    fun initDataBase(context: Context) {
        mTheDB = ECommerceDB.getDatabase(context)
    }

    fun loadCategory(delegate: CategoryDelegate) {
        ECommerceDataAgent.loadCategory(AppConstants.ACCESS_TOKEN,
            mCategoryPage,
            object : CategoryResponseDelegate {
                override fun onSuccess(data: MutableList<CategoryVO>) {
                    val insertedCategories = mTheDB.CategoryDao().insertCategory(data)
                    Log.d(ECommerceApp.TAG, "insertedCategories : ${insertedCategories.size}")
                    val categoriesList = mTheDB.CategoryDao().getAllCategory()
                    Log.d(ECommerceApp.TAG, "categoriesList : ${categoriesList.size}")
                    //delegate.onSuccessCategory(data)
                    delegate.onSuccessCategory(categoriesList)
                }

                override fun onFail(error: String) {
                    delegate.onFail(error)
                }

            })
    }

    fun loadProduct(delegate: ProductDelegate) {
        ECommerceDataAgent.loadProduct(AppConstants.ACCESS_TOKEN,
            mProductPage,
            object : ProductResponseDelegate {
                override fun onSuccess(data: MutableList<ProductsVO>) {
                    val insertedProducts = mTheDB.ProductDao().insertProduct(data)
                    Log.d(ECommerceApp.TAG, "insertedProducts : ${insertedProducts.size}")
                    val productList = mTheDB.ProductDao().getAllProduct()
                    Log.d(ECommerceApp.TAG, "categoriesList : ${productList.size}")
                    //delegate.onSuccessProduct(data)
                    delegate.onSuccessProduct(productList)
                }

                override fun onFail(error: String) {
                    delegate.onFail(error)
                }

            })
    }

    fun getProductByID(productId : Int) : ProductsVO? {
        return mTheDB.ProductDao().getProductById(productId)
    }
}