package com.tinno.test.itms.utils

import android.content.Context
import android.content.SharedPreferences
import com.tinno.test.itms.AnyTestApplication

class SPUtils private constructor() {
    private var mSP: SharedPreferences? = null

    init {
        mSP = AnyTestApplication.getApplicationContext()
            .getSharedPreferences("SharedPreference", Context.MODE_PRIVATE)
    }

    companion object {
        val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { SPUtils() }
    }


    fun putString(key: String, value: String) {
        mSP?.edit()?.let {
            it.putString(key, value)
            it.apply()
        } ?: let {
            throw RuntimeException("在使用之前,请先调用init()方法进行初始化")
        }
    }

    fun getString(key: String, defaultValue: String): String {
        mSP?.let {
            return it.getString(key, defaultValue) ?: defaultValue
        } ?: let {
            return defaultValue
        }
    }

    fun putInt(key: String, value: Int) {
        mSP?.edit()?.let {
            it.putInt(key, value)
            it.apply()
        } ?: let {
            throw RuntimeException("在使用之前,请先调用init()方法进行初始化")
        }
    }

    fun getInt(key: String, defaultValue: Int): Int {
        mSP?.let {
            return it.getInt(key, defaultValue)
        } ?: let {
            throw RuntimeException("在使用之前,请先调用init()方法进行初始化")
        }
    }

    fun putBoolean(key: String, value: Boolean) {
        mSP?.edit()?.let {
            it.putBoolean(key, value)
            it.apply()
        } ?: let {
            throw RuntimeException("在使用之前,请先调用init()方法进行初始化")
        }
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        mSP?.let {
            return it.getBoolean(key, defaultValue)
        } ?: let {
            throw RuntimeException("在使用之前,请先调用init()方法进行初始化")
        }
    }

    fun putFloat(key: String, value: Float) {
        mSP?.edit()?.let {
            it.putFloat(key, value)
            it.apply()
        } ?: let {
            throw RuntimeException("在使用之前,请先调用init()方法进行初始化")
        }
    }

    fun getFloat(key: String, defaultValue: Float): Float {
        mSP?.let {
            return it.getFloat(key, defaultValue)
        } ?: let {
            throw RuntimeException("在使用之前,请先调用init()方法进行初始化")
        }
    }

    fun putLong(key: String, value: Long) {
        mSP?.edit()?.let {
            it.putLong(key, value)
            it.apply()
        } ?: let {
            throw RuntimeException("在使用之前,请先调用init()方法进行初始化")
        }
    }

    fun getLong(key: String, defaultValue: Long): Long {
        mSP?.let {
            return it.getLong(key, defaultValue)
        } ?: let {
            throw RuntimeException("在使用之前,请先调用init()方法进行初始化")
        }
    }

    fun removeKey(key: String) {
        mSP?.edit()?.let {
            it.remove(key)
        } ?: let {
            throw RuntimeException("在使用之前,请先调用init()方法进行初始化")
        }
    }

    fun clear() {
        mSP?.edit()?.let {
            it.clear()
        }
    }
}