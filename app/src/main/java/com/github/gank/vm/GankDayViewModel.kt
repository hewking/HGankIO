package com.github.gank.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.gank.repo.GankDayRepo

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

    lateinit var data : MutableLiveData<String>

    fun init(){
        data = MutableLiveData<String>()
        GankDayRepo.gankDay().subscribe {
            data.value = it
        }
    }



}