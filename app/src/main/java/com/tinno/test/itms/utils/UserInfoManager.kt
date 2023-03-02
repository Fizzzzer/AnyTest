package com.tinno.test.itms.utils

import com.tinno.test.itms.constant.SPKey
import com.tinno.test.itms.model.LoginResponseModel

/**
 * @Author:Fizzer
 * @Email: qianqian.ma@tinno.com
 * @Date: 2023/2/3
 * @Descript: 个人信息管理类
 */
object UserInfoManager {

    /**
     * 保存用户信息
     */
    fun saveUserInfo(userInfo: LoginResponseModel.UserInfo?) {
        userInfo?.let {
            SPUtils.instance.putString(SPKey.KEY_NICK_NAME, it.nickName)
        }
    }
}