package com.tinno.test.itms.page.tool

import androidx.lifecycle.viewModelScope
import com.tinno.test.itms.base.BaseViewModel
import com.tinno.test.itms.download.DownLoadListener
import com.tinno.test.itms.download.DownLoadManager
import kotlinx.coroutines.launch

class ToolsViewModel:BaseViewModel() {

    fun downloadFile(listener: DownLoadListener) {
        viewModelScope.launch {
            DownLoadManager.instance.downFile(listener)
        }
    }
}