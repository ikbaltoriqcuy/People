package com.pcs.peoplelist.ui.adapter.holder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pcs.common.base.BaseViewHolder
import com.pcs.common.utils.ViewUtils.onSetClickOnce
import com.pcs.peoplelist.databinding.PeopleItemBinding
import com.pcs.peoplelist.repository.model.People

/**
Created by ikbaltoriq on 28,August,2024
 **/
class PeopleViewHolder(
    val context: Context,
    parent: ViewGroup,
    inflater: LayoutInflater
): BaseViewHolder<PeopleItemBinding>(
    binding = PeopleItemBinding.inflate(inflater, parent, false)
) {

    fun bind(item: People, onClickItemListener: (People) -> Unit = {}) {
        Glide.with(context)
            .load(item.avatar)
            .placeholder(com.pcs.common.R.drawable.ic_avatar_default)
            .error(com.pcs.common.R.drawable.ic_avatar_default)
            .apply(RequestOptions.circleCropTransform())
            .into(binding.imgProfile)

        binding.item = item
        binding.root.onSetClickOnce {
            onClickItemListener(item)
        }
    }
}