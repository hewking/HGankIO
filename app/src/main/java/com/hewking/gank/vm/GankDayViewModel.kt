package com.hewking.gank.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hewking.gank.bean.GankDayBean
import com.hewking.gank.repo.GankDayRepo
import io.reactivex.disposables.CompositeDisposable

/**
 * @program: HGankIO
 *
 * @description: ${description}
 *
 * @author: hewking
 *
 * @create: 2019-02-23 14:42
 **/
class GankDayViewModel : ViewModel(){

    private val compositeDisposable by lazy {CompositeDisposable()}

    lateinit var data : LiveData<List<GankDayBean>>

    fun init(){
        data = GankDayRepo.gankDay()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun deleteData(gankDayBean: GankDayBean) {
        GankDayRepo.deleteData(gankDayBean)
    }

    fun refresh() {
        GankDayRepo.refresh()
    }

}