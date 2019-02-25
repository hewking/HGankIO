package com.github.gank.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.gank.bean.GankDayBean
import com.github.gank.repo.GankDayRepo
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

}