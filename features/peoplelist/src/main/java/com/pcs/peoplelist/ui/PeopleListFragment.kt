package com.pcs.peoplelist.ui

import android.view.View
import com.pcs.common.base.BaseFragment
import com.pcs.peoplelist.R
import com.pcs.peoplelist.databinding.FragmentPeopleListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleListFragment : BaseFragment<FragmentPeopleListBinding>() {
    override fun layoutId(): Int {
        return R.layout.fragment_people_list
    }

    override fun onViewCreated(view: View) {
    }

}