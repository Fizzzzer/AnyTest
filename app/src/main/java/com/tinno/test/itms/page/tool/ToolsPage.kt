package com.tinno.test.itms.page.tool

import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.tinno.test.itms.base.BaseActivity
import com.tinno.test.itms.databinding.ActivityToolsLayoutBinding
import com.tinno.test.itms.download.DownLoadListener
import com.tinno.test.itms.model.ToolsModel
import com.tinno.test.itms.utils.ToastUtils
import java.io.File

class ToolsPage : BaseActivity<ActivityToolsLayoutBinding, ToolsViewModel>() {

    private val mToolsAdapter by lazy { ToolsListAdapter() }

    override fun getViewModelClass(): Class<ToolsViewModel>? = ToolsViewModel::class.java

    override fun bindingLayoutInflate(layoutInflater: LayoutInflater): ActivityToolsLayoutBinding {
        return ActivityToolsLayoutBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.toolsListView.apply {
            layoutManager = GridLayoutManager(this@ToolsPage, 3)
            adapter = mToolsAdapter
        }
    }


    override fun initData() {
        super.initData()
        val tools = arrayListOf(
            ToolsModel("", "AutoTestTool"),
            ToolsModel("", "MTBFTools"),
            ToolsModel("", "FieldTester"),
            ToolsModel("", "YGPS"),
            ToolsModel("", "AnyTest"),
            ToolsModel("", "SmartDou"),
            ToolsModel("", "Android_Fizzer")
        )
        mToolsAdapter.addData(tools)
    }

    override fun initEvent() {
        super.initEvent()

        binding.downLoad.setOnClickListener { mViewModel?.downloadFile(object :DownLoadListener{
            override fun onSuccess(file: File) {
                ToastUtils.showToast(this@ToolsPage,"文件下载成功${file.path}")
            }

            override fun onFail(errorCode: Int, errorMsg: String) {
                ToastUtils.showToast(this@ToolsPage,"文件下载失败$errorMsg")
            }

            override fun onProgress(progress: Int) {
            }
        }) }
    }
}