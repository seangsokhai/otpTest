package com.example.otpmobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.otpmobile.adaptor.ViewPagerAdaptor
import com.example.otpmobile.databinding.FragmentBannerPageBinding
import com.example.otpmobile.ulti.ImageLists


class BannerPage : Fragment() {
    private var _binding: FragmentBannerPageBinding? = null
    private val binding get() = _binding!!
    private var viewPager2 : ViewPager2? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBannerPageBinding.inflate(inflater,container,false)
        return binding.root
        // Inflate the layout for this fragment
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        binding.btnContinuesOnboard.setOnClickListener {
            findNavController().navigate(
                R.id.action_bannerPage_to_FirstFragment
            )
        }
    }

    private fun setupViewPager(){
        val adaptor = ViewPagerAdaptor(ImageLists.imageSliders)
        viewPager2 = binding.viewpager
        viewPager2?.adapter = adaptor
        binding.dotIndicator.setViewPager2(viewPager2!!)

    }

    override fun onDestroy() {
        super.onDestroy()
    }


}