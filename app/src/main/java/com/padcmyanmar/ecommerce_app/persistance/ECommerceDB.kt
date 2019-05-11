package com.padcmyanmar.ecommerce_app.persistance

import android.arch.persistence.room.*
import android.content.Context
import com.padcmyanmar.ecommerce_app.data.vos.CategoryVO
import com.padcmyanmar.ecommerce_app.data.vos.ProductsVO
import com.padcmyanmar.ecommerce_app.persistance.dao.CategoryDao
import com.padcmyanmar.ecommerce_app.persistance.dao.ProductDao
import com.padcmyanmar.ecommerce_app.persistance.typeconverters.CategoryTypeConverter
import com.padcmyanmar.ecommerce_app.persistance.typeconverters.ProductImageTypeConverter

@Database(entities = arrayOf(ProductsVO::class, CategoryVO::class), version = 5, exportSchema = false)
@TypeConverters(ProductImageTypeConverter::class,CategoryTypeConverter::class)
abstract class ECommerceDB: RoomDatabase() {
    abstract fun ProductDao() : ProductDao
    abstract fun CategoryDao() : CategoryDao

    companion object {
        private val DB_NAME = "ECommerceApp.DB"
        private var INSTANCE : ECommerceDB? = null

        fun getDatabase(context: Context): ECommerceDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, ECommerceDB::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                    .build()
            }
            val i = INSTANCE
            return i!!
        }
    }
}