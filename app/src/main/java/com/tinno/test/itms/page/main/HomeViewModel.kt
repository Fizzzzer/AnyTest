package com.tinno.test.itms.page.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tinno.test.itms.model.ProjectMainModel
import com.tinno.test.itms.net.DataStore
import com.tinno.test.itms.net.RetrofitClient
import com.tinno.test.itms.utils.LoginManager

class HomeViewModel : ViewModel() {

    val projectListLiveData: LiveData<ProjectMainModel?> get() = _projectListLiveData
    private val _projectListLiveData: MutableLiveData<ProjectMainModel?> = MutableLiveData()

    fun getData() {
        DataStore.mInstance.request(this,
            requestBlock = {
                RetrofitClient.INSTANCE.api()
                    .pullProjectList(
                        page = 1,
                        limit = 20,
                        sort = "create_time",
                        order = "desc",
                        session = LoginManager.getToken(),
                        token = LoginManager.getToken()
                    )
            },
            onSuccess = {
                _projectListLiveData.postValue(it)
            })
    }
}