package com.padcmyanmar.ecommerce_app.adapters

import android.content.Context
import android.view.ViewGroup
import com.padcmyanmar.ecommerce_app.R
import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO
import com.padcmyanmar.ecommerce_app.delegates.ProductItemDelegate
import com.padcmyanmar.ecommerce_app.views.holders.BaseViewHolder
import com.padcmyanmar.ecommerce_app.views.holders.CategoryViewHolder
import com.padcmyanmar.ecommerce_app.views.holders.ProductViewHolder

class ProductAdapter (context: Context, private val mDelegate: ProductItemDelegate) : BaseRecyclerAdapter<ProductViewHolder, ProductsVO> (context){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ProductsVO> {
        val productItemView = mLayoutInflator.inflate(R.layout.view_item_product, parent, false)
        return ProductViewHolder(productItemView, mDelegate)
    }


}