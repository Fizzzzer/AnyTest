package com.tinno.test.itms.download

import java.io.File

/**
 * @Author:Fizzer
 * @Email: qianqian.ma@tinno.com
 * @Date: 2023/3/6
 * @Descript: 文件下载的回调
 */
interface DownLoadListener {

    fun onSuccess(file: File)

    fun onFail(errorCode: Int, errorMsg: String)

    fun onProgress(progress: Int)
}