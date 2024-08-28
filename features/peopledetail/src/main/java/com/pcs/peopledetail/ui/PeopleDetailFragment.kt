package com.pcs.peopledetail.ui

import android.view.View
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pcs.common.base.BaseFragment
import com.pcs.common.router.DataCarrier
import com.pcs.peopledetail.R
import com.pcs.peopledetail.databinding.FragmentPeopleDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PeopleDetailFragment : BaseFragment<FragmentPeopleDetailBinding>() {

    @Inject
    lateinit var dataCarrier: DataCarrier
    private val vm: PeopleDetailViewModel by viewModels()

    override fun layoutId(): Int {
        return R.layout.fragment_people_detail
    }

    override fun onViewCreated(view: View) {
        binding.vm = vm
        vm.setPerson(dataCarrier.data)
    }

    override fun obverseData() {
        vm.imgAvatar.observe(viewLifecycleOwner) { imgUrl ->
            loadImageAvatar(imgUrl)
        }
    }

    private fun loadImageAvatar(imgUrl: String) {
        Glide.with(requireContext())
            .load(imgUrl)
            .error(R.drawable.ic_avatar_default)
            .apply(RequestOptions.circleCropTransform())
            .into(binding.imgProfile)
    }

}