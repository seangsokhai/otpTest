package com.example.otpmobile.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.otpmobile.adaptor.ViewPagerAdaptor
import com.example.otpmobile.databinding.FragmentHomePageBinding
import com.example.otpmobile.ulti.ImageLists

class HomePage : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!
    private var viewPager2 : ViewPager2? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager(){
        val adaptor = ViewPagerAdaptor(ImageLists.imageSliders)
        viewPager2 = binding.viewpagerHomePage
        viewPager2?.adapter = adaptor
        binding.dotIndicatorHomePage.setViewPager2(viewPager2!!)

    }


}