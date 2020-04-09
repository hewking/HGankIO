package com.hewking.gank.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hewking.gank.data.entity.GirlEntity

@Dao
interface GirlDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(girls: List<GirlEntity>)

    @Query("SELECT * from t_girl")
    fun getAllGirls(): LiveData<List<GirlEntity>>

}