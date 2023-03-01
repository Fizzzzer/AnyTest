package com.tinno.test.itms.page.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tinno.test.itms.base.BaseViewModel
import com.tinno.test.itms.net.DataStore
import com.tinno.test.itms.net.RetrofitClient

class LoginViewModel : BaseViewModel() {
    val loginState: LiveData<String> get() = _loginState
    private val _loginState: MutableLiveData<String> = MutableLiveData()


    fun doLogin() {
        val params = HashMap<String, String>()
        params["username"] = "Qianqian.ma"
        params["password"] = "Qianqian.ma"
        DataStore.mInstance.request(this,
            requestBlock = {
                RetrofitClient.INSTANCE.api().doLogin(params)
            },
            onSuccess = {
                _loginState.postValue("nickName = ${it?.userInfo?.nickName} token = ${it?.token}")
            })
    }

}