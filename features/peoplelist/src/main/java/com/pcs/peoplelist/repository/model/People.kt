package com.pcs.peoplelist.repository.model

/**
Created by ikbaltoriq on 28,August,2024
 **/

data class People(
    val createdAt: String,
    val name: String,
    val avatar: String,
    val city: String,
    val country: String,
    val county: String,
    val addressNo: String,
    val street: String,
    val zipCode: String,
    val id: String
)