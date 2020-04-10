package com.hewking.gank.data.database

import android.content.Context
import androidx.room.*
import com.hewking.gank.data.database.dao.GirlDao
import com.hewking.gank.data.entity.GirlEntity

@Database(entities = [GirlEntity::class], version = 1, exportSchema = false)
@TypeConverters(GankConverter::class)
abstract class AppDatabase : RoomDatabase(){

    abstract fun getGirlDao(): GirlDao

    companion object {

        private const val DATABASE_NAME = "gank-db"

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context,AppDatabase::class.java, DATABASE_NAME).build()
        }
    }

}