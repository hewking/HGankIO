package com.hewking.gank.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

interface Api {


    @GET("/api/v2/data/category/Girl/type/Girl/page/1/count/10")
    fun girls() : Observable<ResponseBody>


}