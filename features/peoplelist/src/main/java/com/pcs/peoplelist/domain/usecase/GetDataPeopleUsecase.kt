package com.pcs.peoplelist.domain.usecase

import com.pcs.common.network.Result
import com.pcs.peoplelist.repository.model.People
import com.pcs.peoplelist.repository.remote.PeopleRepoImpl
import javax.inject.Inject

/**
Created by ikbaltoriq on 28,August,2024
 **/
class GetDataPeopleUseCase @Inject constructor(
    private val repo: PeopleRepoImpl
) {

    suspend fun invoke(): Result<MutableList<People>> {
        return repo.getDataPeople()
    }
}