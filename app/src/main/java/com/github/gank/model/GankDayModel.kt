package com.github.gank.model

import com.github.gank.api.GankRetrofit
import com.github.gank.network.Rx
import com.github.gank.api.Api
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody

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
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .compose(Rx.transform(String::class.java))
    }

}