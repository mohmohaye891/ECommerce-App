package com.padcmyanmar.ecommerce_app.mvp.presenters

import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO
import com.padcmyanmar.ecommerce_app.delegates.ProductDelegate
import com.padcmyanmar.ecommerce_app.mvp.views.ProductDetailsView

interface ProductDetailsPresenter : ProductDelegate{

   fun showProductDetails()
}

