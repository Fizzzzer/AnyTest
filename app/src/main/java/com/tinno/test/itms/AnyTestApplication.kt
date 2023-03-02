package com.tinno.test.itms

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class AnyTestApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var mContext: Context
        fun getApplicationContext(): Context = mContext
    }


    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext
    }
}