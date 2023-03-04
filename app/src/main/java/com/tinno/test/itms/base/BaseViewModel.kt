package com.tinno.test.itms.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {


    //页面Toast的LiveData
    val mToastLiveData: LiveData<String> get() = _mToastLiveData
    private val _mToastLiveData: MutableLiveData<String> = MutableLiveData()

    //退出登录的LiveData
    val logoutLiveData: LiveData<Boolean> get() = _logoutLiveData
    private val _logoutLiveData: MutableLiveData<Boolean> = MutableLiveData()

    /**
     * 显示Toast
     */
    fun showToast(msg: String) {
        _mToastLiveData.postValue(msg)
    }

    /**
     * 显示退出弹框
     */
    fun showLogoutDialog() {
        _logoutLiveData.postValue(true)
    }
}