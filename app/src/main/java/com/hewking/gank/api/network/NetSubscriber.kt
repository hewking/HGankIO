package com.hewking.gank.api.network

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @program: HGankIO
 * @author: hewking
 * @create: 2019-02-23 18:24
 * @description: ${description}
 **/
open class NetSubscriber<T> : Observer<T>{
    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
    }


}