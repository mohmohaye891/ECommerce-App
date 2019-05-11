package com.padcmyanmar.ecommerce_app.delegates

import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO

interface ProductItemDelegate {
    fun onTapProduct(product: ProductsVO)
}