package com.tinno.test.itms.page.login

import android.view.LayoutInflater
import com.tinno.test.itms.base.BaseActivity
import com.tinno.test.itms.databinding.ActivityLoginLayoutBinding

class LoginPage : BaseActivity<ActivityLoginLayoutBinding, LoginViewModel>() {


    override fun initEvent() {
//        binding.login.setOnClickListener {
//            mViewModel?.doLogin()
//        }

        mViewModel?.loginState?.observe(this) {
            mViewModel?.showToast(it)
            
        }
    }

    override fun bindingLayoutInflate(layoutInflater: LayoutInflater) =
        ActivityLoginLayoutBinding.inflate(layoutInflater)

    override fun getViewModelClass(): Class<LoginViewModel> = LoginViewModel::class.java

}