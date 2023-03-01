package com.tinno.test.itms.net

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.text.SimpleDateFormat
import java.util.*

class NetLogInterceptor :Interceptor{


    private val tag = "okhttp"
    private val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")

    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()

        Log.i(
            tag,
            format.format(Date()) + " Requeste " + "\nmethod:" + request.method + "\nurl:" + request.url + "\nbody:" + request.body
        )

        var response = chain.proceed(request)

        //response.peekBody不会关闭流
        Log.i(
            tag,
            format.format(Date()) + " Response " + "\nsuccessful:" + response.isSuccessful + "\nbody:" + response.peekBody(
                1024
            ).string()
        )

        return response
    }

}