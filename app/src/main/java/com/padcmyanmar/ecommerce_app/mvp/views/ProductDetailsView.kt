package com.padcmyanmar.ecommerce_app.mvp.views

import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO

interface ProductDetailsView  {

    fun showProductDetails(productList: ProductsVO)
}