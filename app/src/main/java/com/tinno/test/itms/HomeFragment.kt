package com.tinno.test.itms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tinno.test.itms.databinding.FragmentHomeLayoutBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }
}