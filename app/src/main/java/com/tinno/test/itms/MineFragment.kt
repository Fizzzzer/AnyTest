package com.tinno.test.itms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tinno.test.itms.databinding.FragmentHomeLayoutBinding
import com.tinno.test.itms.databinding.FragmentMineLayoutBinding
import com.tinno.test.itms.databinding.FragmentReportLayoutBinding

class MineFragment : Fragment() {

    private lateinit var binding: FragmentMineLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMineLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }
}