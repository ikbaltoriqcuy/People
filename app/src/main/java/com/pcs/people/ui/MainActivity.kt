package com.pcs.people.ui

import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.pcs.common.base.BaseActivity
import com.pcs.people.R
import com.pcs.people.databinding.ActivityMainBinding
import com.pcs.people.router.AppRouter

class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var navController: NavController
    lateinit var appRouter: AppRouter
    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate() {
        navController = findNavController(R.id.navHost)
        appRouter = AppRouter(navController)
    }

}