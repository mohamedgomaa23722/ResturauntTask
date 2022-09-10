package com.gomaa.resturanttask.Utils

import androidx.recyclerview.widget.DiffUtil
import com.gomaa.resturanttask.data.categories.Category
import com.gomaa.resturanttask.data.offers.mostSellItem.MostSellItem
import com.gomaa.resturanttask.data.restaurants.FullResturant

class DiffUtils<K>(val type: Int) : DiffUtil.ItemCallback<K>() {
    override fun areItemsTheSame(oldItem: K, newItem: K): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: K, newItem: K): Boolean = when (type) {
        0 -> {
            //category type
            (oldItem as Category).id == (newItem as Category).id
        }
        1 -> {
            //restaurant type
            (oldItem as FullResturant).restaurantId == (newItem as FullResturant).restaurantId
        }
        else -> {
            //menu category type
            (oldItem as MostSellItem).menuCategory.id == (newItem as MostSellItem).menuCategory.id
        }

    }
}