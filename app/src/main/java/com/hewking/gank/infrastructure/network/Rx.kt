package com.hewking.gank.infrastructure.network

import com.hewking.gank.infrastructure.network.type.TypeBuilder
import com.hewking.gank.util.GsonUtil
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
                                val status = jsonObject.optInt("status")
                                if (status == StatusCode.success) {
                                    val dataJson = jsonObject.optString("data")
                                    return GsonUtil.fromJson(dataJson,clazz)
                                } else {
                                    throw NetException(status)
                                }
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())

            }
        }
    }

    fun <T> transformList(clazz: Class<T>) : ObservableTransformer<ResponseBody,List<T>>{
        return object : ObservableTransformer<ResponseBody,List<T>>{
            override fun apply(upstream: Observable<ResponseBody>): ObservableSource<List<T>> {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(object : Function<ResponseBody,List<T>>{
                            override fun apply(t: ResponseBody): List<T> {
                                val result = t.string()
                                val jsonObject = JSONObject(result)
                                val status = jsonObject.optInt("status")
                                if (StatusCode.success == status) {
                                    val dataJson = jsonObject.optString("data")
                                    // 是不可以这样的
                                    val type = TypeBuilder.newInstance(List::class.java).addTypeParam(clazz).build()
                                    return GsonUtil.fromJson(dataJson,type)
                                } else {
                                    throw NetException(status)
                                }
                            }

                        })
            }

        }
    }

}