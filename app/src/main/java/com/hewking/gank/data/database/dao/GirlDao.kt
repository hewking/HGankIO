package com.hewking.gank.data.database.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.hewking.gank.data.entity.GirlEntity

@Dao
interface GirlDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(girls: List<GirlEntity>)

    @Query("SELECT * from t_girl")
    fun getAllGirls(): DataSource.Factory<Int,GirlEntity>

    @Delete
    fun delete(girl: GirlEntity)

}