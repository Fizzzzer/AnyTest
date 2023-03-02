package com.tinno.test.itms.page.login

import android.content.Intent
import android.view.LayoutInflater
import com.tinno.test.itms.page.main.MainActivity
import com.tinno.test.itms.base.BaseActivity
import com.tinno.test.itms.databinding.ActivityLoginLayoutBinding

class LoginPage : BaseActivity<ActivityLoginLayoutBinding, LoginViewModel>() {


    override fun initEvent() {
        binding.btnLogin.setOnClickListener {
            doLogin()
        }
    }

    override fun initObserver() {
        super.initObserver()
        mViewModel?.loginState?.observe(this) {
            if (it) startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun bindingLayoutInflate(layoutInflater: LayoutInflater) =
        ActivityLoginLayoutBinding.inflate(layoutInflater)

    override fun getViewModelClass(): Class<LoginViewModel> = LoginViewModel::class.java


    private fun doLogin() {
        if (checkVerify()) {
            mViewModel?.doLogin(binding.user.text.toString(), binding.passWord.text.toString())
        }
    }


    /**
     * 检查当前是否可以点击登录
     */
    private fun checkVerify(): Boolean {
        if (binding.user.text.isNullOrEmpty()) {
            mViewModel?.showToast("请输入用户名和密码")
            return false
        }

        if (binding.passWord.text.isNullOrEmpty()) {
            mViewModel?.showToast("请输入密码")
            return false
        }
        return true
    }
}