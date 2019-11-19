package com.github.hgankio.app

import android.app.Application
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.crashlytics.android.Crashlytics


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
        Crashlytics.log("firebase crasyh android test")
    }

}