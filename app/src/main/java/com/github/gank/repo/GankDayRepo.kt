package com.github.gank.repo

import com.github.gank.model.GankDayModel
import io.reactivex.Observable

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