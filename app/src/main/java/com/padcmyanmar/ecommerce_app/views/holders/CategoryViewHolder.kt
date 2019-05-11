package com.padcmyanmar.ecommerce_app.views.holders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.ecommerce_app.data.vos.CategoryVO
import kotlinx.android.synthetic.main.view_item_category.view.*

class CategoryViewHolder(itemView: View ) : BaseViewHolder<CategoryVO>(itemView) {

    override fun setData(data: CategoryVO) {

        mData = data
        Glide.with(itemView.context)
            .load(data.categoryIcon)
            .into(itemView.ivCategory)

        itemView.tvCategoryName.text = data.categoryName

    }

    override fun onClick(v: View?) {

    }


}