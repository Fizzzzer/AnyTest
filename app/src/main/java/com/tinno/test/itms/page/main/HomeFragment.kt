package com.tinno.test.itms.page.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.chad.library.adapter.base.animation.AlphaInAnimation
import com.tinno.test.itms.R
import com.tinno.test.itms.databinding.FragmentHomeLayoutBinding
import com.tinno.test.itms.model.BannerModel
import com.tinno.test.itms.page.login.LoginPage
import com.tinno.test.itms.page.tool.ToolsPage
import com.tinno.test.itms.utils.LoginManager
import com.tinno.test.itms.widget.EmptyView
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator

class HomeFragment : Fragment() {

    private lateinit var mViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeLayoutBinding

    //项目的适配器
    private val mProjectAdapter by lazy { ProjectListAdapter() }

    private val mEmptyView by lazy { context?.let { EmptyView(it) } }

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
        initObserver()
        initData()
    }

    private fun initView() {
        initBannerView()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.projectListView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            mProjectAdapter.adapterAnimation = AlphaInAnimation()
            adapter = mProjectAdapter
        }
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
        binding.toolsContent.setOnClickListener {
            startActivity(Intent(context, ToolsPage::class.java))
        }
    }

    private fun initObserver() {
        mViewModel.projectListLiveData.observe(viewLifecycleOwner) {
            it?.let {
                it.list?.let { data ->
                    mProjectAdapter.addData(data)
                }
            } ?: let {
                mEmptyView?.let { emptyView ->
                    mProjectAdapter.setEmptyView(emptyView)
                }
            }
        }

        mViewModel.logoutLiveData.observe(viewLifecycleOwner) {
            LoginManager.logOut()
            startActivity(Intent(context, LoginPage::class.java))
        }
    }


    private fun initData() {
        mViewModel.getData()
    }

}