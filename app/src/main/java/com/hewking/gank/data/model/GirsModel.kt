package com.hewking.gank.data.model

import com.hewking.gank.api.Api
import com.hewking.gank.infra.network.GankRetrofit
import com.hewking.gank.infra.network.Rx
import com.hewking.gank.data.entity.GirlEntity
import io.reactivex.Observable

class GirlsModel {

    fun getGirls(): Observable<List<GirlEntity>>{
        return GankRetrofit.create(Api::class.java)
                .girls()
                .compose(Rx.transformList(GirlEntity::class.java))
    }

}