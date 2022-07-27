package com.example.shoppinglist.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ShopItemDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun shopListDao(): ShopListDao

    companion object {
        private var instance: AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "shop_item.db"

        fun getInstance(application: Application): AppDatabase {
            instance?.let {
                return it
            }
            synchronized(LOCK) {
                instance?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                ).allowMainThreadQueries()
                 .build()
                instance = db
                return db
            }
        }
    }
}