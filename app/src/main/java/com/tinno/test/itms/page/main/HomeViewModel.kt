package com.tinno.test.itms.page.main

import androidx.lifecycle.ViewModel
import com.tinno.test.itms.net.DataStore
import com.tinno.test.itms.net.RetrofitClient
import com.tinno.test.itms.utils.LoginManager

class HomeViewModel : ViewModel() {


    fun getData() {
        DataStore.mInstance.request(this,
            requestBlock = {
                RetrofitClient.INSTANCE.api()
                    .pullProjectList(
                        page = 1,
                        limit = 20,
                        sort = "create_time",
                        order = "desc",
                        session = "fcf6f059-bdc9-49ab-9bd9-a9c691928ac2",
                        token = "fcf6f059-bdc9-49ab-9bd9-a9c691928ac2"
                    )
            },
            onSuccess = {})
    }
}