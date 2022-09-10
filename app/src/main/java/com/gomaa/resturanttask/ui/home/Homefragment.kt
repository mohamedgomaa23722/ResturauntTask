package com.gomaa.resturanttask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.gomaa.resturanttask.data.categories.Category
import com.gomaa.resturanttask.data.offers.mostorders.MostOrdered
import com.gomaa.resturanttask.data.offers.mostSellItem.MostSellItem
import com.gomaa.resturanttask.data.restaurants.FullResturant
import com.gomaa.resturanttask.databinding.FragmentHomefragmentBinding
import com.gomaa.resturanttask.ui.Adapter.ItemsAdapter
import com.gomaa.resturanttask.ui.Adapter.SliderAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*


@AndroidEntryPoint
class Homefragment(

) : Fragment() {
    lateinit var viewModel: HomeViewModel
    lateinit var binding: FragmentHomefragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomefragmentBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
        SetUpViews()


        SetupAdsSlider()
        return binding.root
    }

    /**
     * Setup view with our generic Adapter class and hide view while getting data from server
     * and pass view model to viewModel object we have created on home fragment layout
     */
    private fun SetUpViews() {
        //Pass view model to data binding or variable into data binding
        binding.viewModel = viewModel
        //Set visibility of parent view as Gone
        binding.parentView.visibility = View.GONE
        //Then Initialize category adapter with view type zero for it's view
        binding.CategoryList.adapter = ItemsAdapter<Category>(0)
        //Then Initialize adapters which based on Restaurant with view type one for it's view
        binding.VendorList.adapter = ItemsAdapter<FullResturant>(1)
        binding.LastOffersList.adapter = ItemsAdapter<FullResturant>(1)
        binding.NearestBranchList.adapter = ItemsAdapter<FullResturant>(1)
        binding.FreeDeliveryBranchesList.adapter = ItemsAdapter<FullResturant>(1)
        //Then Initialize adapter which based on MostSellItem with view type two for it's view
        binding.MostSellList.adapter = ItemsAdapter<MostSellItem>(2)
        binding.MostBranchList.adapter = ItemsAdapter<MostOrdered>(3)

    }

    /**
     * Setup ads slider we only apply the upper slide and others has same idea
     * so initialization process includes fill adapter with data and apply
     * auto slide every 3 seconds
     */
    private fun SetupAdsSlider() {
        //this job is start via fragment life cycle
        lifecycleScope.launchWhenStarted {
            //at first collect data of Ads data
            viewModel.AdsData.collect {
                //check if data is not Empty
                if (it.isNotEmpty()) {
                    //adapter initialization
                    val upperSliderAdapter =
                        context?.let { it1 -> SliderAdapter(it1, it[0].AdsSpacesprice) }
                    val middleSliderAdapter =
                        context?.let { it1 -> SliderAdapter(it1, it[1].AdsSpacesprice) }
                    val bottomSliderAdapter =
                        context?.let { it1 -> SliderAdapter(it1, it[2].AdsSpacesprice) }
                    //pass adapter to view pager adapter
                    binding.AdsSlider.adapter = upperSliderAdapter
                    binding.MidAdsSlider.adapter = middleSliderAdapter
                    binding.BottomdSlider.adapter = bottomSliderAdapter
                    //Setup indicator with view pager
                    binding.indicator.setupWithViewPager(binding.AdsSlider)
                    binding.Midindicator.setupWithViewPager(binding.MidAdsSlider)
                    binding.Bottomindicator.setupWithViewPager(binding.BottomdSlider)
                }
            }
        }

        //create new job for auto slider
        lifecycleScope.launchWhenStarted {
            while (true) {
                SlideViewPager()
                delay(3000)
            }
        }
    }

    /**
     * This function for cycle sliding
     */
    fun SlideViewPager() {
        if (binding.AdsSlider.size == binding.AdsSlider.currentItem) {
            binding.AdsSlider.setCurrentItem(0, true)
            binding.MidAdsSlider.setCurrentItem(0, true)
            binding.BottomdSlider.setCurrentItem(0, true)
        } else {
            binding.AdsSlider.setCurrentItem(binding.AdsSlider.currentItem + 1, true)
            binding.MidAdsSlider.setCurrentItem(binding.AdsSlider.currentItem + 1, true)
            binding.BottomdSlider.setCurrentItem(binding.AdsSlider.currentItem + 1, true)
        }
    }


}