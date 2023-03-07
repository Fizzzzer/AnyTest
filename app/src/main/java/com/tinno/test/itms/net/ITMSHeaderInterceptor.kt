package com.tinno.test.itms.net

import com.tinno.test.itms.utils.LoginManager
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ITMSHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val oldRequest = chain.request()
            .newBuilder()
            .addHeader("JSESSIONID", LoginManager.getToken())
            .addHeader("X-Tfts-Token", LoginManager.getToken())
            .build()
        return chain.proceed(oldRequest)
    }
}