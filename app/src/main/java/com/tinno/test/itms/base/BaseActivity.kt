package com.tinno.test.itms.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.tinno.test.itms.page.login.LoginPage
import com.tinno.test.itms.utils.LoginManager
import com.tinno.test.itms.utils.ToastUtils

abstract class BaseActivity<T : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {
    lateinit var binding: T

    var mViewModel: VM? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingLayoutInflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initView()
        initEvent()
        initData()
        initObserver()
    }

    abstract fun getViewModelClass(): Class<VM>?

    private fun initViewModel() {
        getViewModelClass()?.let {
            mViewModel = ViewModelProvider(this).get(it)
        }

    }


    //初始化ViewBinding
    abstract fun bindingLayoutInflate(layoutInflater: LayoutInflater): T

    //初始化视图
    open fun initView() {}

    //初始化事件
    open fun initEvent() {}

    //初始化数据
    open fun initData() {}

    //初始化观察者
    open fun initObserver() {
        mViewModel?.mToastLiveData?.observe(this) {
            ToastUtils.showToast(this, it)
        }

        mViewModel?.logoutLiveData?.observe(this) {
            LoginManager.logOut()
            startActivity(Intent(this, LoginPage::class.java))
        }
    }
}