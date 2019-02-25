package com.github.gank.repo

import androidx.lifecycle.LiveData
import com.github.gank.bean.GankDayBean
import com.github.gank.dao.GankDayDao
import com.github.gank.db.GankRoomDB
import com.github.gank.model.GankDayModel

/**
 * @program: HGankIO
 * @description: ${description}
 * @author: hewking
 * @create: 2019-02-23 17:31
 **/
object GankDayRepo{

    private lateinit var gankDay : LiveData<List<GankDayBean>>
    private val gankDayDao : GankDayDao = GankRoomDB.getInstance().gankDayDao()

    private val gankModel by lazy {
        GankDayModel()
    }

    fun gankDay() : LiveData<List<GankDayBean>>{
        gankDay = gankDayDao.getAll()
        gankModel.gankToday().subscribe({
            gankDayDao.insertAll(it[0])
        },{

        })
        return gankDay


    }

}