package com.padcmyanmar.ecommerce_app.mvp.views

import com.padcmyanmar.ecommerce_app.data.vos.CategoryVO
import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO

interface ProductsListView {

    fun displayCategoryList(categoryList : MutableList<CategoryVO>)

    fun displayProductList(productList: MutableList<ProductsVO>)

    fun goProductDetails(productList: ProductsVO)
}