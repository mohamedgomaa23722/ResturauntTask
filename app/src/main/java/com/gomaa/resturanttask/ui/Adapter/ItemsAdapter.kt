package com.gomaa.resturanttask.ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.gomaa.resturanttask.BR

import com.gomaa.resturanttask.Utils.DiffUtils
import com.gomaa.resturanttask.databinding.BranchItemBinding
import com.gomaa.resturanttask.databinding.CategoryItemBinding
import com.gomaa.resturanttask.databinding.DishesItemBinding
import com.gomaa.resturanttask.databinding.ResturantItemBinding
import com.gomaa.resturanttask.ui.Adapter.viewHolder.ItemsViewHolder

/**
 * Generic Item Adapter Class Depend on K and type of the view to Initialize the
 * adapter as we are targeting so K is refers to data model object and type is
 * viewType of the view
 */
class ItemsAdapter<K : Any?>(val type: Int) :
    ListAdapter<K, ItemsViewHolder<K>>(DiffUtils<K>(type)) {
    /**
     * At onCreateViewHolder we handle it by using type variable to
     * return the right ViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder<K> =
        when (type) {
            0 -> {
                // this is the category List
                ItemsViewHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context)))
            }
            1 -> {
                //Here we need to observe restaurant item
                ItemsViewHolder(ResturantItemBinding.inflate(LayoutInflater.from(parent.context)))
            }
            2 -> {
                //Here we need to observe menuCategory item
                ItemsViewHolder(DishesItemBinding.inflate(LayoutInflater.from(parent.context)))
            }
            else -> {
                ItemsViewHolder(BranchItemBinding.inflate(LayoutInflater.from(parent.context)))
            }
        }

    /**
     * At onBindViewHolder we also handle the data binding by pass the right
     * object to target viewHolder to bind data on correct view
     */
    override fun onBindViewHolder(holder: ItemsViewHolder<K>, position: Int) {
        val item = getItem(position)
        when (type) {
            0 -> {
                // pass data as category
                holder.bind(item, BR.data)
            }
            1 -> {
                // pass data as restaurant
                holder.bind(item, BR.resturant)
            }
            2 -> {
                // pass data as menuCategory
                holder.bind(item, BR.dishes)
            }
            else -> {
                holder.bind(item, BR.subresturant)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(type)
    }
}