package com.tinno.test.itms.model

data class LoginResponseModel(val token: String = "", val userInfo: UserInfo? = null) {

    data class UserInfo(val nickName: String)
}