package com.tinno.test.itms.net

class ResultData<T>(
    val errmsg: String = "",
    val errno: Int = 0,
    val data: T? = null
) {

    fun isSuccess(): Boolean {
        return errno == 0
    }
}