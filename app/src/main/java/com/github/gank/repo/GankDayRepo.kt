package com.github.gank.repo

import com.github.gank.model.GankDayModel
import io.reactivex.Observable
import okhttp3.ResponseBody

/**
 * @program: HGankIO
 * @description: ${description}
 * @author: hewking
 * @create: 2019-02-23 17:31
 **/
object GankDayRepo{

    private val gankModel by lazy {
        GankDayModel()
    }

    fun gankDay() : Observable<String>{
        return gankModel.gankToday()
    }

}