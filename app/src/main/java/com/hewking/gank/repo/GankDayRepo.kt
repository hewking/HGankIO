package com.hewking.gank.repo

import androidx.lifecycle.LiveData
import com.hewking.gank.bean.GankDayBean
import com.hewking.gank.dao.GankDayDao
import com.hewking.gank.db.GankRoomDB
import com.hewking.gank.model.GankDayModel
import io.reactivex.*
import io.reactivex.schedulers.Schedulers

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
        return gankDay
    }

    fun deleteData(gankDayBean: GankDayBean) {
        Maybe.fromAction<Unit> {
            gankDayDao.deleteItem(gankDayBean)
        }.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe {
                }
    }

    fun refresh() {
        gankModel.gankToday()
                .observeOn(Schedulers.io())
                .subscribe({
                    gankDayDao.insertAll(it)
                },{

                })
    }

}