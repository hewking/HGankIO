package com.github.gank.repo

import androidx.lifecycle.LiveData
import com.github.gank.bean.GankDayBean
import com.github.gank.dao.GankDayDao
import com.github.gank.db.GankRoomDB
import com.github.gank.model.GankDayModel
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
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