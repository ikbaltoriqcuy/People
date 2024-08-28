package com.pcs.peoplelist.ui.adapter.holder

import android.content.Context
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pcs.common.base.BaseViewHolder
import com.pcs.peoplelist.R
import com.pcs.peoplelist.databinding.PeopleItemBinding
import com.pcs.peoplelist.repository.model.People

/**
Created by ikbaltoriq on 28,August,2024
 **/
class PeopleViewHolder(
    val context: Context,
    inflater: LayoutInflater
): BaseViewHolder<PeopleItemBinding>(
    binding = PeopleItemBinding.inflate(inflater)
) {

    fun bind(item: People) {
        Glide.with(context)
            .load(item.avatar)
            .error(R.drawable.ic_avatar_default)
            .apply(RequestOptions.circleCropTransform())
            .into(binding.imgProfile)

        binding.item = item
    }
}