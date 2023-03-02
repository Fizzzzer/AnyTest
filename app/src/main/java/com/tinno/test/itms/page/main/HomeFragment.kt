package com.tinno.test.itms.page.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.tinno.test.itms.R
import com.tinno.test.itms.databinding.FragmentHomeLayoutBinding
import com.tinno.test.itms.model.BannerModel
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator

class HomeFragment : Fragment() {

    private lateinit var mViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeLayoutBinding.inflate(inflater, container, false)
        mViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initEvent()
    }

    private fun initView() {
        initBannerView()
    }

    /**
     * 初始化Banner
     */
    private fun initBannerView() {
        val bannerData = arrayListOf(
            BannerModel(R.drawable.image_cloud_phone, "云真机"),
            BannerModel(R.drawable.image_knowledge, "知识"),
            BannerModel(R.drawable.image_tools, "工具")
        )
        binding.banner.setAdapter(object : BannerImageAdapter<BannerModel>(bannerData) {
            override fun onBindView(
                holder: BannerImageHolder?, data: BannerModel?,
                position: Int, size: Int
            ) {
                data?.let {

                    holder?.imageView?.load(it.resID)
                }
            }
        }).addBannerLifecycleObserver(this).indicator = CircleIndicator(context)
    }

    private fun initEvent() {
        binding.btn.setOnClickListener {
            mViewModel.getData()
        }
    }

}