package com.pcs.people.router

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.pcs.people.R

/**
Created by ikbaltoriq on 28,August,2024
 **/
class AppRouter(private val navController: NavController) {

    fun gotoPeopleDetail(bundle: Bundle = bundleOf()) {
        navController.navigate(R.id.peopleListFragment, bundle)
    }

    fun back(bundle: Bundle = bundleOf()) {
        navController.popBackStack()
    }
}