package com.github.gank.dao;

import com.github.gank.bean.GankDayBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * 项目名称：FlowChat
 * 类的描述：
 * 创建人员：hewking
 * 创建时间：2019/2/25 0025:18:36
 * 修改人员：hewking
 * 修改时间：2019/2/25 0025 18 36
 * 修改备注：
 * Version: 1.0.0
 */
@Dao
public interface GankDayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<GankDayBean> bean);

    @Query("DELETE FROM t_gankday")
    void deleteAll();

    @Query("SELECT * FROM t_gankday")
    LiveData<List<GankDayBean>> getAll();

    @Delete
    void deleteItem(GankDayBean item);

}
