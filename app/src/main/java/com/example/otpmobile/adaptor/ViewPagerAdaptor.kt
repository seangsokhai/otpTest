package com.example.otpmobile.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.otpmobile.databinding.ImageViewpagerItemBinding
import com.example.otpmobile.model.local.ImageSlider

class ViewPagerAdaptor(private val bannerList: List<ImageSlider>) : RecyclerView.Adapter<ViewPagerAdaptor.ViewPagerViewHolder>(){
    inner class ViewPagerViewHolder(private val binding: ImageViewpagerItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindItem(image: ImageSlider){
            binding.imageBannerTv.setImageResource(image.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        return ViewPagerViewHolder(
            ImageViewpagerItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bindItem(bannerList[position])
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }
}