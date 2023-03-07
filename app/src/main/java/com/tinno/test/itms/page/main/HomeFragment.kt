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
import com.tinno.test.itms.base.BaseFragment
import com.tinno.test.itms.databinding.FragmentHomeLayoutBinding
import com.tinno.test.itms.model.BannerModel
import com.tinno.test.itms.page.login.LoginPage
import com.tinno.test.itms.page.tool.ToolsPage
import com.tinno.test.itms.utils.LoginManager
import com.tinno.test.itms.widget.EmptyView
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator

class HomeFragment : BaseFragment<FragmentHomeLayoutBinding, HomeViewModel>() {

    //项目的适配器
    private val mProjectAdapter by lazy { ProjectListAdapter() }

    private val mEmptyView by lazy { context?.let { EmptyView(it) } }


    override fun initView() {
        super.initView()
        binding.appTitle.apply {
            title = "项目"
            iconVisible = false
        }
        initBannerView()
        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.projectListView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            mProjectAdapter.adapterAnimation = AlphaInAnimation()
            adapter = mProjectAdapter
        }

        binding.refreshLayout.setEnableLoadMore(false)
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

    override fun initEvent() {
        super.initEvent()
        binding.toolsContent.setOnClickListener {
            startActivity(Intent(context, ToolsPage::class.java))
        }

        binding.refreshLayout.setOnRefreshListener {
            mViewModel?.getData()
        }
    }

    override fun initObserver() {
        super.initObserver()
        mViewModel?.projectListLiveData?.observe(viewLifecycleOwner) {
            binding.refreshLayout.finishRefresh()
            it?.let {
                it.list?.let { data ->
                    mProjectAdapter.data.clear()
                    mProjectAdapter.addData(data)
                }
            } ?: let {
                mEmptyView?.let { emptyView ->
                    mProjectAdapter.data.clear()
                    mProjectAdapter.notifyDataSetChanged()
                    mProjectAdapter.setEmptyView(emptyView)
                }
            }
        }
    }


    override fun initData() {
        super.initData()
        mViewModel?.getData()
    }

    override fun bindingLayoutInflate(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeLayoutBinding {
        return FragmentHomeLayoutBinding.inflate(inflater, container, false)
    }

    override fun getViewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

}