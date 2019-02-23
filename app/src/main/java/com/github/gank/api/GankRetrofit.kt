package com.github.gank.api

import com.github.gank.app.C
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * @program: HGankIO
 * @author: hewking
 * @create: 2019-02-23 17:35
 * @description: 用于封装retrofit ,okhttp
 **/
object GankRetrofit {

    private val retrofit : Retrofit

    init {

        val client = OkHttpClient.Builder()
//                .addInterceptor(HttpLoggingInterceptor())
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(C.BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
    }

    fun <T> create(api : Class<T>) : T{
        return retrofit.create(api)
    }

}