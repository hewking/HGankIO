package com.github.gank.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.POST

interface Api {


    @POST("/api/today")
    fun todayGan() : Observable<ResponseBody>


}