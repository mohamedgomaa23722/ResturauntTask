package com.gomaa.resturanttask.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.gomaa.resturanttask.data.ads.AdsSpacesPrice
import com.gomaa.resturanttask.databinding.SliderItemBinding

class SliderAdapter constructor(
    private val context: Context,
    private var AdsList: List<AdsSpacesPrice>?
) :
    PagerAdapter() {

    override fun getCount(): Int = AdsList!!.size


    override fun isViewFromObject(view: View, `object`: Any): Boolean = (view == `object`)

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = SliderItemBinding.inflate(LayoutInflater.from(context))
        binding.sliderAds = AdsList?.get(position)?.sliders
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view: View = `object` as View
        container.removeView(view)
    }
}