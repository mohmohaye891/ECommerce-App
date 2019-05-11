package com.padcmyanmar.ecommerce_app.adapters

import android.content.Context
import android.view.ViewGroup
import com.padcmyanmar.ecommerce_app.R
import com.padcmyanmar.ecommerce_app.data.vos.CategoryVO
import com.padcmyanmar.ecommerce_app.views.holders.CategoryViewHolder

class CategoryAdapter (context: Context) : BaseRecyclerAdapter<CategoryViewHolder, CategoryVO>(context){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val categoryItemView = mLayoutInflator.inflate(R.layout.view_item_category, parent, false)
        return CategoryViewHolder(categoryItemView)
    }
}