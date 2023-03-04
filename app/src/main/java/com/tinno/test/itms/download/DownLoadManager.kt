package com.tinno.test.itms.download

import android.util.Log
import com.tinno.test.itms.net.DataStore
import com.tinno.test.itms.net.RetrofitClient
import java.io.File
import java.io.InputStream
import java.io.OutputStream

class DownLoadManager private constructor() {
    companion object {
        val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { DownLoadManager() }
    }

    val url =
        "http://itms.tinno.com:9000/tfts-prod/tools/73211297418004512/2023.03.03_12.03.52/AutoTestTool_M02_M01_R28.rar"

    suspend fun downFile() {
        val file = File("sdcard/MTBF")
        if (!file.exists()) {
            file.mkdirs()
        }
        val downLoadFile = File(file,"file.rar")
        val response = RetrofitClient.INSTANCE.api().downLoad(url)
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
                    Log.e("Fizzer","percent = $percent")
                    //更新完成UI之后立刻切回IO线程
                }

                len = inStream?.read(buff) ?: -1
            }

            Log.e("Fizzer","下载完成")
        }
    }
}