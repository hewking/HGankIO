package com.github.gank.model

import com.github.gank.api.GankRetrofit
import com.github.gank.network.Rx
import com.github.gank.api.Api
import io.reactivex.Observable

/**
 * @program: HGankIO
 * @author: hewking
 * @create: 2019-02-23 17:54
 * @description: ${description}
 **/
class GankDayModel {

    fun gankToday() : Observable<String>{
        return GankRetrofit.create(Api::class.java)
                .todayGan()
                .compose(Rx.transform(String::class.java))
    }

}