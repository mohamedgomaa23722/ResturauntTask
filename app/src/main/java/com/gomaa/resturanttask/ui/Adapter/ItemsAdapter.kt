package com.gomaa.resturanttask.ui.Adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.gomaa.resturanttask.databinding.CategoryItemBinding

class ItemsAdapter<K>(val ViewType: Int) :
    RecyclerView.Adapter<ItemsViewHolder<K>>() {
    private var list: List<K> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<K>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder<K> {
        Log.d("ItemsAdapter", "onCreateViewHolder: $viewType")
        return ItemsViewHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemsViewHolder<K>, position: Int) {
        val item = list[position]
        Log.d("ItemsAdapter", "onBindViewHolder: ${item.toString()}")
        holder.bindCategories(item)
    }

    override fun getItemCount(): Int =list.size


}