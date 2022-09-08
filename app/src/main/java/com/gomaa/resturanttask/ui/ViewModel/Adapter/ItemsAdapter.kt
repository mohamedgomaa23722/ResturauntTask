package com.gomaa.resturanttask.ui.ViewModel.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gomaa.resturanttask.Utils.DiffUtils
import com.gomaa.resturanttask.databinding.CategoryItemBinding

class ItemsAdapter<K:Any?>(val ViewType: Int) :
    ListAdapter<K, ItemsViewHolder<K>>(DiffUtils<K>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder<K> {
        if (viewType == 0) {
            //Here this is the category List
            return ItemsViewHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context)))
        }
        return ItemsViewHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemsViewHolder<K>, position: Int) {
        val item = getItem(position)
        holder.bindCategories(item)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(ViewType)
    }
}