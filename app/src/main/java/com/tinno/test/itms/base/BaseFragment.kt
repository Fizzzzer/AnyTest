package com.tinno.test.itms.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.tinno.test.itms.page.login.LoginPage
import com.tinno.test.itms.utils.LoginManager
import com.tinno.test.itms.utils.ToastUtils

abstract class BaseFragment<VB : ViewBinding,VM:BaseViewModel> : Fragment() {

    lateinit var binding: VB
    var mViewModel: VM? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = bindingLayoutInflate(layoutInflater,container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initView()
        initEvent()
        initData()
        initObserver()
    }


    private fun initViewModel() {
        getViewModelClass()?.let {
            mViewModel = ViewModelProvider(this).get(it)
        }
    }

    //初始化视图
    open fun initView() {}

    //初始化事件
    open fun initEvent() {}

    //初始化数据
    open fun initData() {}

    //初始化观察者
    open fun initObserver() {
        mViewModel?.mToastLiveData?.observe(viewLifecycleOwner) {
            ToastUtils.showToast(context, it)
        }

        mViewModel?.logoutLiveData?.observe(viewLifecycleOwner) {
            LoginManager.logOut()
            startActivity(Intent(activity, LoginPage::class.java))
        }
    }


    //初始化ViewBinding
    abstract fun bindingLayoutInflate(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun getViewModelClass(): Class<VM>?
}