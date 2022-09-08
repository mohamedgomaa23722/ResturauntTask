package com.gomaa.resturanttask.Utils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class DiffUtils<K : Any?> : DiffUtil.ItemCallback<K>() {
    override fun areItemsTheSame(oldItem: K, newItem: K): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: K, newItem: K): Boolean {
        return oldItem == newItem
    }
}