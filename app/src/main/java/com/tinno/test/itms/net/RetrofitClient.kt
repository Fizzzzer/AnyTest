package com.tinno.test.itms.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient private constructor() {

    private val baseUrl = "http://itms.tinno.com/"

    companion object {
        val INSTANCE: RetrofitClient by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { RetrofitClient() }
    }

    private fun createOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
//            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(NetLogInterceptor())
            .build()
    }

    fun api(): ApiServices {
        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(createOkhttpClient())
            .build()

        return retrofit.create(ApiServices::class.java)
    }

}