package com.tinno.test.itms.download

import android.os.Build
import android.os.Environment
import android.util.Log
import androidx.annotation.RequiresApi
import com.tinno.test.itms.AnyTestApplication
import com.tinno.test.itms.net.DataStore
import com.tinno.test.itms.net.RetrofitClient
import okhttp3.ResponseBody
import java.io.File
import java.io.InputStream
import java.io.OutputStream

class DownLoadManager private constructor() {
    companion object {
        val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { DownLoadManager() }
    }

    val url =
        "https://github.com/Fizzzzer/FizzerLib/blob/master/app/build.gradle"

    suspend fun downFile(downLoadListener: DownLoadListener? = null) {
        val file = File("${AnyTestApplication.getCacheDirPath()}/AnyTest")
        Log.e("Fizzer", "File.path = ${file.path}")
        if (!file.exists()) {
            val result = file.mkdir()
            Log.e("Fizzer", "mkfile result = $result")
        }
        val downLoadFile = File(file, "file.txt")
        var response: ResponseBody? = null
        try {
            response = RetrofitClient.INSTANCE.testApi("https://github.com/").downLoad(url)
        } catch (ex: Exception) {
            downLoadListener?.onFail(-1, ex.message ?: "未知错误")
            Log.e("Fizzer", ex.message.toString())
            return
        }
        var inStream: InputStream? = null
        var outStream: OutputStream? = null
        kotlin.runCatching {
            inStream = response.byteStream()
            outStream = downLoadFile.outputStream()
            val contentLength = response.contentLength()
            var currentLength = 0L
            val buff = ByteArray(1024)
            var len = inStream?.read(buff) ?: -1
            var percent = 0
            while (len != -1) {
                outStream?.write(buff, 0, len)
                currentLength += len
                /*不要频繁的调用切换线程,否则某些手机可能因为频繁切换线程导致卡顿,
                这里加一个限制条件,只有下载百分比更新了才切换线程去更新UI*/
                if ((currentLength * 100 / contentLength).toInt() > percent) {
                    percent = (currentLength / contentLength * 100).toInt()
                    Log.e("Fizzer", "percent = $percent")
                    //更新完成UI之后立刻切回IO线程
                    downLoadListener?.onProgress(percent)
                }
                len = inStream?.read(buff) ?: -1
            }
            Log.e("Fizzer", "下载完成")
            downLoadListener?.onSuccess(downLoadFile)
        }
    }
}