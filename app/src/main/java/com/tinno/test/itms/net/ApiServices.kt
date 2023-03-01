package com.tinno.test.itms.net

import com.tinno.test.itms.model.LoginResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServices {

    @POST("api/auth/login")
    suspend fun doLogin(
        @Body body: HashMap<String,String>
    ): ResultData<LoginResponseModel>
}