package com.pcs.people.ui

import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.pcs.common.base.BaseActivity
import com.pcs.people.R
import com.pcs.people.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var navController: NavController
    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate() {
        navController = findNavController(R.id.navHost)
        onBackPressedDispatcher.addCallback(this , object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navController.popBackStack()
            }
        })
    }

}