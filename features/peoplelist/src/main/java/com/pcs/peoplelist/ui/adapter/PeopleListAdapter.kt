package com.pcs.peoplelist.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pcs.common.base.BaseListAdapter
import com.pcs.peoplelist.repository.model.People
import com.pcs.peoplelist.ui.adapter.holder.PeopleViewHolder


/**
Created by ikbaltoriq on 28,August,2024
 **/
class PeopleListAdapter(val context: Context, val onClickItemListener: (People) -> Unit = {}) :
    BaseListAdapter<People>(
        itemsSame = { old, new -> old.id == new.id },
        contentsSame = { old, new -> old == new }
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int,
    ): RecyclerView.ViewHolder {
        return PeopleViewHolder(context, inflater)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as PeopleViewHolder).bind(item, onClickItemListener)
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    fun updateData(items: MutableList<People>) {
        submitList(items)
        notifyItemRangeChanged(0, items.size)
    }

}
