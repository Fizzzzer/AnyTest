package com.tinno.test.itms

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class AnyTestApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var mContext: Context
        fun getApplicationContext(): Context = mContext

        /**
         * 获取缓存文件的存储路径
         */
        fun getCacheDirPath(): String = mContext.cacheDir.path

        /**
         * 获取文件路径
         */
        fun getFileDirPath(): String = mContext.filesDir.path
    }


    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext
    }
}