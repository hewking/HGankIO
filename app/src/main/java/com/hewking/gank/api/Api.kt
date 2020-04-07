package com.hewking.gank.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

interface Api {


    @GET("/api/today")
    fun todayGan() : Observable<ResponseBody>


}