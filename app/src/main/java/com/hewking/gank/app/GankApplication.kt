package com.hewking.gank.app;
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//@HiltAndroidApp
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