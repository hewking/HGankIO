package com.github.hgankio.app

import android.app.Application

/**
test 2019/2/23
 **/
class GankApplication : Application(){

    companion object {

        private lateinit var app : Application

        fun getApp() : Application{
            return app
        }
    }


    override fun onCreate() {
        super.onCreate()
        app = this
    }

}