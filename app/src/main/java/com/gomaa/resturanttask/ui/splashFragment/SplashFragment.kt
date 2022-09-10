package com.gomaa.resturanttask.ui.splashFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.gomaa.resturanttask.R
import com.gomaa.resturanttask.Utils.ApiResult
import com.gomaa.resturanttask.databinding.FragmentSplashBinding
import com.gomaa.resturanttask.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSplashBinding.inflate(layoutInflater)
        binding.lifecycleOwner=this

        val viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding.splashViewModel = viewModel

        lifecycleScope.launchWhenStarted {
            viewModel.statue.collect{
                if (it == ApiResult.Success){
                    findNavController().navigate(R.id.action_splashFragment_to_homefragment)
                }else if (it != ApiResult.Loading){
                    binding.resultText.text = "Some thing went wrong Check your Internet"
                }
            }

        }
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

}