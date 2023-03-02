package com.tinno.test.itms

import android.content.Intent
import android.view.LayoutInflater
import com.tinno.test.itms.base.BaseActivity
import com.tinno.test.itms.base.BaseViewModel
import com.tinno.test.itms.databinding.ActivitySplashLayoutBinding
import com.tinno.test.itms.page.login.LoginPage
import com.tinno.test.itms.page.main.MainActivity
import com.tinno.test.itms.utils.LoginManager

class SplashActivity : BaseActivity<ActivitySplashLayoutBinding, BaseViewModel>() {

    override fun bindingLayoutInflate(layoutInflater: LayoutInflater): ActivitySplashLayoutBinding =
        ActivitySplashLayoutBinding.inflate(layoutInflater)


    override fun initView() {
        binding.splashBg.postDelayed({
            if (LoginManager.isLogin()) {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            } else {
                startActivity(Intent(this@SplashActivity, LoginPage::class.java))
            }
            finish()
        }, 2000L)
    }

    override fun getViewModelClass(): Class<BaseViewModel>? = null
}