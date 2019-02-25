package com.github.gank.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.github.gank.bean.GankDayBean;

import java.util.List;

import androidx.lifecycle.LiveData;

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
    @Insert
    void insertAll(GankDayBean bean);

    @Query("DELETE FROM t_gankday")
    void deleteAll();

    @Query("SELECT * FROM t_gankday ORDER BY createdAt ASC")
    LiveData<List<GankDayBean>> getAll();

}
