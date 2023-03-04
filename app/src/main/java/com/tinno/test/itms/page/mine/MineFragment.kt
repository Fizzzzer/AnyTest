package com.tinno.test.itms.page.mine

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tinno.test.itms.databinding.FragmentHomeLayoutBinding
import com.tinno.test.itms.databinding.FragmentMineLayoutBinding
import com.tinno.test.itms.databinding.FragmentReportLayoutBinding
import com.tinno.test.itms.page.login.LoginPage
import com.tinno.test.itms.utils.LoginManager

class MineFragment : Fragment() {

    private lateinit var binding: FragmentMineLayoutBinding
    private lateinit var mViewModel: MineViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMineLayoutBinding.inflate(inflater, container, false)
        mViewModel = ViewModelProvider(this).get(MineViewModel::class.java)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initView()
        initObserver()
    }

    private fun initView() {
        binding.logout.setOnClickListener { mViewModel.showLogoutDialog() }
    }

    private fun initObserver() {
        mViewModel.logoutLiveData.observe(viewLifecycleOwner){
            LoginManager.logOut()
            startActivity(Intent(context, LoginPage::class.java))
        }
    }
}