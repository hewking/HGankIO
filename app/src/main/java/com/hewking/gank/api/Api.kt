package com.hewking.gank.api

import com.hewking.gank.data.entity.GirlEntity
import com.hewking.gank.infra.network.BaseResponse
import retrofit2.http.GET

interface Api {

    @GET("/api/v2/data/category/Girl/type/Girl/page/1/count/50")
    suspend fun getGirls(): BaseResponse<List<GirlEntity>>


}