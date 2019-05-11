package com.padcmyanmar.ecommerce_app.mvp.presenters

import com.padcmyanmar.ecommerce_app.data.models.ECommerceAppModel
import com.padcmyanmar.ecommerce_app.data.vos.CategoryVO
import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO
import com.padcmyanmar.ecommerce_app.delegates.CategoryDelegate
import com.padcmyanmar.ecommerce_app.delegates.ProductDelegate
import com.padcmyanmar.ecommerce_app.delegates.ProductResponseDelegate
import com.padcmyanmar.ecommerce_app.mvp.views.ProductsListView

class ProductListPresenterImpl(productsListView: ProductsListView) : BasePresenter<ProductsListView>(productsListView), ProductListPresenter  {

    private var mProductListView = productsListView


    private lateinit var mProductModel : ECommerceAppModel


    override fun onUIReady() {

        mProductModel.loadProduct(object : ProductDelegate{
            override fun onSuccessProduct(data: MutableList<ProductsVO>) {
                mProductListView.displayProductList(data)
            }

            override fun onFail(error: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

        mProductModel.loadCategory(object : CategoryDelegate{
            override fun onSuccessCategory(data: MutableList<CategoryVO>) {
                mProductListView.displayCategoryList(data)
            }

            override fun onFail(error: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

    }

    override fun onSuccessProduct(data: MutableList<ProductsVO>) {

    }

    override fun onFail(error: String) {

    }

    override fun onStart() {

    }

    override fun onStop() {

    }



}