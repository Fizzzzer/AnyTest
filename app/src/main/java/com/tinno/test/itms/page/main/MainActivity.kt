package com.tinno.test.itms.page.main

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.tinno.test.itms.page.mine.MineFragment
import com.tinno.test.itms.ReportFragment
import com.tinno.test.itms.ViewPagerAdapter
import com.tinno.test.itms.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainAdapter by lazy {
        ViewPagerAdapter(
            this,
            arrayListOf(HomeFragment(), ReportFragment(), MineFragment())
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }


    private fun initView() {
        initViewPager()
        initBottomNav()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE),1000)
        }
    }

    /**
     * 初始化ViewPager
     */
    private fun initViewPager() {
        //设置适配器
        binding.mainViewPager.adapter = mainAdapter
        //设置页面选择回调监听
        binding.mainViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bottomNav.menu.getItem(position).isChecked = true
            }
        })
    }

    /**
     * 初始化BottomNavigationView
     */
    private fun initBottomNav() {
        //设置底部导航栏的点击监听
        binding.bottomNav.setOnItemSelectedListener {
            //设置当前viewPager的页面，order是在menu中设置的orderInCategory属性
            binding.mainViewPager.setCurrentItem(it.order, false)
            true
        }
    }

}