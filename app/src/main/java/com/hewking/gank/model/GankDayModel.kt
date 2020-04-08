package com.hewking.gank.model

import com.hewking.gank.api.GankRetrofit
import com.hewking.gank.api.network.Rx
import com.hewking.gank.api.Api
import com.hewking.gank.bean.GankDayBean
import io.reactivex.Observable

/**
 * @program: HGankIO
 * @author: hewking
 * @create: 2019-02-23 17:54
 * @description: ${description}
 **/
class GankDayModel {

    fun gankToday() : Observable<List<GankDayBean>>{
        return GankRetrofit.create(Api::class.java)
                .todayGan()
                .compose(Rx.transformList(GankDayBean::class.java))
    }

}