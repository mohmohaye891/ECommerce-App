package com.padcmyanmar.ecommerce_app.events

import com.padcmyanmar.ecommerce_app.data.vos.CategoryVO
import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO

class DataEvent {

    class ProductsLoadedEvent(val loadedPageIndex: Int, val loadedProducts : List<ProductsVO>)

    class EmptyDataLoadedEvent(val errorMsg: String? = "Empty Body Response")

    class CategoryLoadedEvent(val loadedPageIndex: Int, val loadedCategory: List<CategoryVO>)
}