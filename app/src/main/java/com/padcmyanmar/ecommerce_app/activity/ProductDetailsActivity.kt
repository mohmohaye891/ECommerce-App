package com.padcmyanmar.ecommerce_app.activity

import android.os.Bundle
import com.bumptech.glide.Glide
import com.padcmyanmar.ecommerce_app.R
import com.padcmyanmar.ecommerce_app.data.models.ECommerceAppModel
import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO
import com.padcmyanmar.ecommerce_app.mvp.views.ProductDetailsView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetailsActivity : BaseActivity(), ProductDetailsView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        setSupportActionBar(toolbar)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_grey_24dp)

        val productId : Int = intent.getIntExtra("productID", 1)
        val product = ECommerceAppModel.getProductByID(productId)
        //bindData(product!!)
    }

  /*  private fun bindData(product: ProductsVO) {
        Glide.with(applicationContext)
            .load(product.productImageUrl[0].imageUrl)
            .into(ivProductDetails)

        tvProductDetailsName.text =  product.productName
        tvProductPrice.text = product.price
        tvProductDescription.text = product.desc



    }*/

   /* override fun onSuccessProduct(data: MutableList<ProductsVO>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFail(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }*/

    override fun showProductDetails(product: ProductsVO) {
        Glide.with(applicationContext)
            .load(product.productImageUrl[0].imageUrl)
            .into(ivProductDetails)

        tvProductDetailsName.text =  product.productName
        tvProductPrice.text = product.price
        tvProductDescription.text = product.desc

    }

}