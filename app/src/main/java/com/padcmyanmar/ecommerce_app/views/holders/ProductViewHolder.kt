package com.padcmyanmar.ecommerce_app.views.holders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO
import com.padcmyanmar.ecommerce_app.delegates.ProductItemDelegate
import kotlinx.android.synthetic.main.view_item_product.view.*

class ProductViewHolder (itemView: View, private val mDelegate: ProductItemDelegate) : BaseViewHolder<ProductsVO>(itemView){

    override fun setData(data: ProductsVO) {
        mData = data
        itemView.tvProductName!!.text = data.productName
        itemView.tvProductPrice!!.text = data.price
        Glide.with(itemView.context)
            .load(data.productImageUrl[0].imageUrl)
            .into(itemView.ivProduct)

    }

    override fun onClick(v: View?) {
        mDelegate.onTapProduct(mData!!)
    }
}