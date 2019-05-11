package com.padcmyanmar.ecommerce_app.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.padcmyanmar.ecommerce_app.R
import com.padcmyanmar.ecommerce_app.adapters.CategoryAdapter
import com.padcmyanmar.ecommerce_app.adapters.ProductAdapter
import com.padcmyanmar.ecommerce_app.data.vos.CategoryVO
import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO
import com.padcmyanmar.ecommerce_app.mvp.presenters.ProductListPresenter
import com.padcmyanmar.ecommerce_app.mvp.views.ProductsListView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), ProductsListView{

    private lateinit var mProductList: ProductListPresenter

    private lateinit var mCategoryAdapter: CategoryAdapter

   // private lateinit var mProductAdapter: ProductAdapter
    private var mProductAdapter : ProductAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        //Category list
        rvCategory.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL,false)
        mCategoryAdapter = CategoryAdapter(applicationContext)
        rvCategory.adapter = mCategoryAdapter


        //For Product List
        rvProduct.layoutManager = GridLayoutManager(applicationContext, 2)
       // mProductAdapter = ProductAdapter(applicationContext, this)
        rvProduct.adapter = mProductAdapter

       /* ECommerceAppModel.loadProduct(this)
        ECommerceAppModel.loadCategory(this)*/

        mProductList.onUIReady()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

   /* override fun onSuccessProduct(data: MutableList<ProductsVO>) {
        mProductAdapter.setNewData(data)
    }

    override fun onFail(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
    }

    override fun onTapProduct(product: ProductsVO) {
        val intent = Intent(applicationContext, ProductDetailsActivity::class.java)
        intent.putExtra("productID", product!!.productID)
        startActivity(intent)
    }

    override fun onSuccessCategory(data: MutableList<CategoryVO>) {
        mCategoryAdapter.setNewData(data)
    }*/


    override fun displayCategoryList(categoryList: MutableList<CategoryVO>) {
       mCategoryAdapter?.setNewData(categoryList)
    }

    override fun displayProductList(productList: MutableList<ProductsVO>) {
        mProductAdapter?.setNewData(productList)
    }

    override fun goProductDetails(product: ProductsVO) {
        val intent = Intent(applicationContext, ProductDetailsActivity::class.java)
        intent.putExtra("productID", product!!.productID)
        startActivity(intent)
    }
}
