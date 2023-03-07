package com.tinno.test.itms

import android.view.LayoutInflater
import android.view.ViewGroup
import com.tinno.test.itms.base.BaseFragment
import com.tinno.test.itms.base.BaseViewModel
import com.tinno.test.itms.databinding.FragmentReportLayoutBinding

class ReportFragment : BaseFragment<FragmentReportLayoutBinding,BaseViewModel>() {
    override fun bindingLayoutInflate(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentReportLayoutBinding {
        return FragmentReportLayoutBinding.inflate(inflater,container,false)
    }

    override fun getViewModelClass(): Class<BaseViewModel> = BaseViewModel::class.java


    override fun initView() {
        super.initView()
        binding.appTitle.apply {
            title = "JIRA"
            iconVisible = false
        }
    }

}