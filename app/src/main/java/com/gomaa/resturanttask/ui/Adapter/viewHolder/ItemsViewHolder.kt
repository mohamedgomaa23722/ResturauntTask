package com.gomaa.resturanttask.ui.Adapter.viewHolder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.gomaa.resturanttask.BR
import com.gomaa.resturanttask.data.offers.mostorders.MostOrdered
import com.gomaa.resturanttask.data.offers.mostSellItem.MostSellItem

/**
 *  ItemsViewHolder Class take ViewDataBinding as value and T -> data model object
 */
class ItemsViewHolder<T>(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    /**
     * bind data to correct view
     */
    fun bind(data: T?, TypeID: Int) {
        when (TypeID) {
            BR.dishes -> {
                // here the we need to pass menuCategory so get menu from MostSellItem object
                val dishes = data as MostSellItem
                binding.setVariable(TypeID, dishes.menuCategory)
            }
            BR.subresturant -> {
                val order = data as MostOrdered
                binding.setVariable(BR.subresturant, order.branches.restaurant)
            }
            BR.resturant -> {
                binding.setVariable(BR.resturant, data)

            }
            else -> {
                binding.setVariable(TypeID, data)
            }
        }
        binding.executePendingBindings()
    }
}