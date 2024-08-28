package com.pcs.common.router

import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import javax.inject.Inject

/**
Created by ikbaltoriq on 28,August,2024
 **/

class AppRouter @Inject constructor(var dataCarrier: DataCarrier) {

    var navController: NavController? = null
    fun gotoPeopleDetail(json: String) {
        val request = NavDeepLinkRequest.Builder
            .fromUri("https://pcs.com/peopleDetailFragment".toUri())
            .build()
        dataCarrier.data = json
        navController?.navigate(request)
    }

    fun back() {
        val request = NavDeepLinkRequest.Builder
            .fromUri("https://pcs.com/peopleListFragment".toUri())
            .build()
        navController?.navigate(request)
    }
}