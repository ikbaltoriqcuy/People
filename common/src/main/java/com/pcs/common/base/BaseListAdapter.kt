package com.pcs.common.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
Created by ikbaltoriq on 27,August,2024
 **/
abstract class BaseListAdapter<T>(
    itemsSame: (T, T) -> Boolean,
    contentsSame: (T, T) -> Boolean,
) : ListAdapter<T, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T & Any, newItem: T & Any): Boolean =
        itemsSame(oldItem, newItem)

    override fun areContentsTheSame(oldItem: T & Any, newItem: T & Any): Boolean =
        contentsSame(oldItem, newItem)
}) {

    abstract fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return onCreateViewHolder(
            parent = parent,
            inflater = LayoutInflater.from(parent.context),
            viewType = viewType
        )
    }
}