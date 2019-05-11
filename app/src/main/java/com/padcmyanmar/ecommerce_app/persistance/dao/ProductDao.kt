package com.padcmyanmar.ecommerce_app.persistance.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(productVO : MutableList<ProductsVO>) : LongArray

    @Query("SELECT * FROM product")
    fun getAllProduct(): MutableList<ProductsVO>

    @Query("SELECT * FROM product WHERE product_id = :id")
    fun getProductById(id:Int) : ProductsVO
}