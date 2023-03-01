package com.tinno.test.itms.base

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    //页面Toast的LiveData
    val mToastLiveData: LiveData<String> get() = _mToastLiveData
    private val _mToastLiveData: MutableLiveData<String> = MutableLiveData()


    /**
     * 显示Toast
     */
    fun showToast(msg: String) {
        _mToastLiveData.postValue(msg)
    }
}