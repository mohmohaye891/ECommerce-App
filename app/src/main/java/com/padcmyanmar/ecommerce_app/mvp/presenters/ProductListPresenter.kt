package com.padcmyanmar.ecommerce_app.mvp.presenters

import com.padcmyanmar.ecommerce_app.data.models.ECommerceAppModel
import com.padcmyanmar.ecommerce_app.data.vos.CategoryVO
import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO
import com.padcmyanmar.ecommerce_app.delegates.CategoryDelegate
import com.padcmyanmar.ecommerce_app.delegates.ProductDelegate
import com.padcmyanmar.ecommerce_app.delegates.ProductItemDelegate
import com.padcmyanmar.ecommerce_app.mvp.views.ProductsListView

interface ProductListPresenter : ProductDelegate{

    fun onUIReady()

}