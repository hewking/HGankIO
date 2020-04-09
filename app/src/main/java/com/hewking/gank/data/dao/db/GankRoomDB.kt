package com.hewking.gank.data.dao.db

import androidx.room.*
import com.hewking.gank.app.GankApplication
import com.hewking.gank.data.bean.GankDayBean
import com.hewking.gank.data.dao.tables.GankDayDao

/**
 * 项目名称：FlowChat
 * 类的描述：
 * 创建人员：hewking
 * 创建时间：2019/2/25 0025:17:44
 * 修改人员：hewking
 * 修改时间：2019/2/25 0025 17 44
 * 修改备注：
 * Version: 1.0.0
 */
@Database(entities = [GankDayBean::class], version = 1)
@TypeConverters(GankConverter::class)
abstract class GankRoomDB : RoomDatabase() {

    abstract fun gankDayDao(): GankDayDao

    companion object {

        private const val DATABASE_NAME = "gank.db"

        private var INSTANCE: GankRoomDB? = null

        fun getInstance(): GankRoomDB {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(GankApplication.getApp(), GankRoomDB::class.java, DATABASE_NAME)
                        .build()
                INSTANCE!!
            } else {
                INSTANCE!!
            }
        }
    }

}