package com.github.gank.network

import com.github.gank.util.GsonUtil
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.json.JSONObject

/**
 * @program: HGankIO
 * @author: hewking
 * @create: 2019-02-23 17:59
 * @description: ${description}
 **/
object Rx {

    fun <T> transform(clazz: Class<T>) : ObservableTransformer<ResponseBody,T>{
        return object : ObservableTransformer<ResponseBody,T>{
            override fun apply(upstream: Observable<ResponseBody>): ObservableSource<T> {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .map(object : Function<ResponseBody,T>{
                            override fun apply(t: ResponseBody): T {
                                val result = t.string()
                                val jsonObject = JSONObject(result)
                                val state = jsonObject.optBoolean("error")
                                if (state) {
                                    val json = jsonObject.optString("results")
                                    val data : T = GsonUtil.fromJson(json,clazz)
                                    return data
                                } else {
                                    throw NetException(state)
                                }
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())

            }
        }

    }

}