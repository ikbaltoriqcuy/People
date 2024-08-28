package com.pcs.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pcs.common.router.AppRouter
import javax.inject.Inject

/**
Created by ikbaltoriq on 27,August,2024
 **/
abstract class BaseFragment<T: ViewDataBinding>: Fragment() {

    @Inject
    lateinit var appRouter: AppRouter
    lateinit var binding: T

    abstract fun layoutId():Int
    abstract fun onViewCreated(view: View)

    protected open fun obverseData() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appRouter.navController = findNavController()
        onViewCreated(view)
        obverseData()
    }
}