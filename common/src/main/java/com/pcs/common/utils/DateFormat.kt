package com.pcs.common.utils

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
Created by ikbaltoriq on 28,August,2024
 **/
object DateFormat {

    const val FORMAT_DATE = "dd MMM yyyy"
    @JvmStatic
    fun formatDateString(dateString: String): String {
        val zonedDateTime = ZonedDateTime.parse(dateString)
        val formatter = DateTimeFormatter.ofPattern(FORMAT_DATE)
        return zonedDateTime.format(formatter)
    }
}