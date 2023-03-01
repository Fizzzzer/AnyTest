package com.tinno.test.itms.utils

import android.content.Context
import android.widget.Toast

/**
 * @Author:Fizzer
 * @Email: qianqian.ma@tinno.com
 * @Date: 2023/2/3
 * @Descript: Toast工具类
 */
object ToastUtils {

    /**
     * 显示Toast
     */
    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }
}