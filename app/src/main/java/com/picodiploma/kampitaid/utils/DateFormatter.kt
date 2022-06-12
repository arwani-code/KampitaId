package com.picodiploma.kampitaid.utils

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {

    fun formatDate(currentDate: String): String? {
        val currentFormat = "yyyy-MM-dd'T'hh:mm:ss'Z'"
        val targetFormat = "dd MMM yyyy | HH:mm"
        val timeZone = "GMT"
        val currentDF: DateFormat = SimpleDateFormat(currentFormat, Locale.getDefault())
        currentDF.timeZone = TimeZone.getTimeZone(timeZone)
        val targetDF: DateFormat = SimpleDateFormat(targetFormat, Locale.getDefault())
        var targetDate: String? = null
        try {
            val date = currentDF.parse(currentDate)
            targetDate = date?.let { targetDF.format(it) }
        }catch (ex: ParseException){
            ex.printStackTrace()
        }
        return targetDate
    }

}