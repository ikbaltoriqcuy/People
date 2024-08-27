package com.pcs.peoplelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pcs.peoplelist.ui.main.PeoplelistFragment

class peoplelist : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peoplelist)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PeoplelistFragment.newInstance())
                .commitNow()
        }
    }
}