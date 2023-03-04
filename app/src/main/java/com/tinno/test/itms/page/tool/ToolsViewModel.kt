package com.tinno.test.itms.page.tool

import androidx.lifecycle.viewModelScope
import com.tinno.test.itms.base.BaseViewModel
import com.tinno.test.itms.download.DownLoadManager
import kotlinx.coroutines.launch

class ToolsViewModel:BaseViewModel() {

    fun downloadFile(){
        viewModelScope.launch {
            DownLoadManager.instance.downFile()
        }
    }
}