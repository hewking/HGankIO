package com.hewking.gank.infra.network

import com.hewking.gank.config.BASEURL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

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
                .addInterceptor(HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
    }

    fun <T> create(api : Class<T>) : T{
        return retrofit.create(api)
    }

}