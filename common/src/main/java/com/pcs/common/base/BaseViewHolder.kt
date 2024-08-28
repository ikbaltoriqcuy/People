package com.pcs.common.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
Created by ikbaltoriq on 27,August,2024
 **/
abstract class BaseViewHolder<T>(
    val binding: T
) : RecyclerView.ViewHolder((binding as ViewDataBinding).root)