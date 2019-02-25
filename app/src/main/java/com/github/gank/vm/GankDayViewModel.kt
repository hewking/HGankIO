package com.github.gank.vm

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

    lateinit var data : MutableLiveData<String>

    fun init(){
        data = MutableLiveData()
        compositeDisposable.add(GankDayRepo.gankDay().subscribe ({
            data.value = it.toString()
        },{
            data.value = "麻痹的 报错了 " + it.message
        }))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}