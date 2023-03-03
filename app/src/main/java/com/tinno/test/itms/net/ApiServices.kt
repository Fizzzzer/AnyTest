package com.tinno.test.itms.net

import com.tinno.test.itms.model.LoginResponseModel
import com.tinno.test.itms.model.ProjectMainModel
import retrofit2.http.*

interface ApiServices {

    @POST("api/auth/login")
    suspend fun doLogin(
        @Body body: HashMap<String, String>
    ): ResultData<LoginResponseModel>

    @GET("api/task/casetodo")
    suspend fun pullProjectList(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("sort") sort: String,
        @Query("order") order: String,
        @Query("JSESSIONID") session: String,
        @Query("X-Tfts-Token") token: String,
    ): ResultData<ProjectMainModel>
}