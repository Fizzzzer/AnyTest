package com.tinno.test.itms.utils

import com.tinno.test.itms.constant.SPKey
import com.tinno.test.itms.model.LoginResponseModel
import java.lang.reflect.Modifier

/**
 * @Author:Fizzer
 * @Email: qianqian.ma@tinno.com
 * @Date: 2023/2/3
 * @Descript: 用户登录管理类
 */
object LoginManager {

    /**
     * 登录成功后的操作
     */
    fun loginSuccess() {

    }

    /**
     * 登录
     */
    fun login(model: LoginResponseModel?) {
        model?.let {
            //保存用户User信息
            UserInfoManager.saveUserInfo(it.userInfo)
            //保存用户Token信息
            SPUtils.instance.putString(SPKey.KEY_ACCESS_TOKEN, it.token)
        }
    }

    /**
     * 登出
     */
    fun logOut() {
        SPUtils.instance.putString(SPKey.KEY_ACCESS_TOKEN, "")
    }

    /**
     * 判断当前用户是否已登录，就判断当前用户的token是否为空
     */
    fun isLogin(): Boolean {
        return SPUtils.instance.getString(SPKey.KEY_ACCESS_TOKEN, "").isNotEmpty()
    }

    /**
     * 获取当前登录用户的Token
     */
    fun getToken():String{
        return SPUtils.instance.getString(SPKey.KEY_ACCESS_TOKEN, "")
    }
}