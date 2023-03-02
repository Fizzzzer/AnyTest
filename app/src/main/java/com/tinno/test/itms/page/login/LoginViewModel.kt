package com.tinno.test.itms.page.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tinno.test.itms.base.BaseViewModel
import com.tinno.test.itms.net.DataStore
import com.tinno.test.itms.net.RetrofitClient
import com.tinno.test.itms.utils.LoginManager

class LoginViewModel : BaseViewModel() {
    val loginState: LiveData<Boolean> get() = _loginState
    private val _loginState: MutableLiveData<Boolean> = MutableLiveData()


    fun doLogin(user: String, passWord: String) {
        val params = HashMap<String, String>()
        params["username"] = user
        params["password"] = passWord
        DataStore.mInstance.request(this,
            requestBlock = {
                RetrofitClient.INSTANCE.api().doLogin(params)
            },
            onSuccess = {
                LoginManager.login(it)
                _loginState.postValue(true)
            })
    }

}