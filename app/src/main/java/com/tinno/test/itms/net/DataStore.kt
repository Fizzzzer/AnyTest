package com.tinno.test.itms.net

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 数据仓库
 */
class DataStore private constructor() {

    companion object {
        val mInstance: DataStore by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { DataStore() }
    }

    fun <T> request(
        viewModel: ViewModel,
        requestBlock: suspend () -> ResultData<T>, onSuccess: (T?) -> Unit
    ) {
        request(
            viewModel, requestBlock, onSuccess,
            onError = { errorCode, errorMsg -> handlerError(errorCode, errorMsg) })
    }

    /**
     * 接口请求数据封装
     */
    fun <T> request(
        viewModel: ViewModel,
        requestBlock: suspend () -> ResultData<T>,
        onSuccess: (T?) -> Unit,
        onError: (errorCode: Int, errorMsg: String) -> Unit
    ) {
        viewModel.viewModelScope.launch(Dispatchers.IO) {
            //做实际的接口请求
            val responseResult = requestBlock.invoke()
            withContext(Dispatchers.Main) {
                if (responseResult.isSuccess()) {
                    //处理成功事件
                    onSuccess.invoke(responseResult.data)
                } else {
                    //处理错误的事件
                    onError.invoke(responseResult.errno, responseResult.errmsg)
                }
            }
        }
    }

    /**
     * 统一的错误处理
     */
    private fun handlerError(errorCode: Int, errorMsg: String) {

    }
}