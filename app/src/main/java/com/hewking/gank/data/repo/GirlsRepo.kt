package com.hewking.gank.data.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.hewking.gank.data.database.AppDatabase
import com.hewking.gank.data.database.dao.GirlDao
import com.hewking.gank.data.entity.GirlEntity
import com.hewking.gank.data.model.GirlsModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * @program: HGankIO
 * @description: ${description}
 * @author: hewking
 * @create: 2019-02-23 17:31
 **/
class GirlsRepo(private val context: Context) {

    private lateinit var girls: LiveData<List<GirlEntity>>
    private val girlDao: GirlDao = AppDatabase.getInstance(context).getGirlDao()
    private val disposable = CompositeDisposable()

    private val girlsModel by lazy {
        GirlsModel()
    }

    fun getGirls(): LiveData<List<GirlEntity>> {
        girls = girlDao.getAllGirls()
        refresh()
        return girls
    }

    fun deleteFromCache(girl: GirlEntity) {
        girlDao.delete(girl)
    }

    fun refresh() {
        disposable.add(girlsModel.getGirls()
                .observeOn(Schedulers.io())
                .subscribe({
                    Log.e("GankRepo", it.toString())
                    girlDao.insertAll(it)
                }, {
                    it.printStackTrace()
                }))
    }

}