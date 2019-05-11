package com.padcmyanmar.ecommerce_app.mvp.presenters

import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO
import com.padcmyanmar.ecommerce_app.mvp.views.ProductDetailsView

class ProductDetailsPresenterImpl (productDetailsView: ProductDetailsView) : BasePresenter<ProductDetailsView>(productDetailsView), ProductDetailsView {


    override fun onStart() {

    }

    override fun onStop() {

    }

    override fun showProductDetails(productList: ProductsVO) {
       mView.showProductDetails(productList)
    }


}