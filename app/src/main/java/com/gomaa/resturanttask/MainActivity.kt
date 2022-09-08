package com.gomaa.resturanttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.gomaa.resturanttask.Utils.ApiResult
import com.gomaa.resturanttask.data.Categories.Category
import com.gomaa.resturanttask.databinding.ActivityMainBinding
import com.gomaa.resturanttask.ui.ViewModel.Adapter.ItemsAdapter
import com.gomaa.resturanttask.ui.ViewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val adapter = ItemsAdapter<Category>(0)
        viewModel = androidx.lifecycle.ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getPost()
        lifecycleScope.launchWhenStarted {
            viewModel._postStateFlow.collect {
                when (it) {
                    is ApiResult.Loading -> Toast.makeText(
                        applicationContext,
                        "Loading",
                        Toast.LENGTH_SHORT
                    ).show()
                    is ApiResult.Error -> Toast.makeText(
                        applicationContext,
                        "Error",
                        Toast.LENGTH_SHORT
                    ).show()
                    is ApiResult.Success -> {
                        Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
                        adapter.submitList(it.data)
                    }
                }
            }
        }

        binding.RecyclerId.adapter = adapter
    }
}