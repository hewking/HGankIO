package com.hewking.gank.api

import com.hewking.gank.data.entity.GirlEntity
import com.hewking.gank.infra.network.CommonResult
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

interface Api {

    @GET("/api/v2/data/category/Girl/type/Girl/page/1/count/50")
    suspend fun getGirls(): CommonResult<List<GirlEntity>>


}