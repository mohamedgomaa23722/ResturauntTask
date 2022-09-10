package com.gomaa.resturanttask.ui.Adapter.viewHolder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.gomaa.resturanttask.BR


class ItemsViewHolder<T>(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindCategories(data:T?) {
        binding.setVariable(BR.data,data)
        binding.executePendingBindings()
    }
}