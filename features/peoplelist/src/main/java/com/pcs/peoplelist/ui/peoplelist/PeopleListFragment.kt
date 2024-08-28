package com.pcs.peoplelist.ui.peoplelist

import android.view.View
import com.pcs.common.base.BaseFragment
import com.pcs.peoplelist.R
import com.pcs.peoplelist.databinding.FragmentPeopleListBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.pcs.peoplelist.repository.model.People
import com.pcs.peoplelist.ui.adapter.PeopleListAdapter

@AndroidEntryPoint
class PeopleListFragment : BaseFragment<FragmentPeopleListBinding>() {

    private val vm: PeopleListViewModel by viewModels()

    private val peopleAdapter by lazy {
        PeopleListAdapter(requireContext()) { people ->
            appRouter.gotoPeopleDetail(Gson().toJson(people))
        }
    }

    override fun layoutId(): Int {
        return R.layout.fragment_people_list
    }

    override fun onViewCreated(view: View) {
        binding.vm = vm
        setupPeopleList()
    }

    override fun obverseData() {
        vm.peopleList.observe(viewLifecycleOwner) { data ->
            updatePeopleList(data)
        }
    }

    private fun setupPeopleList() {
        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)

        with(binding.rvPeople) {
            adapter = peopleAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(dividerItemDecoration)
        }
    }

    private fun updatePeopleList(data: MutableList<People>) {
        peopleAdapter.updateData(data)
    }

}