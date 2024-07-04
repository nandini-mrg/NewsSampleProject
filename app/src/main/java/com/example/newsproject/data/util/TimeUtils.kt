package com.example.newsproject.data.util
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

object TimeUtils {

    fun getTimeDifference(givenDateString: String, pattern: String = "yyyy-MM-dd'T'HH:mm:ss'Z'"): String {
        val formatter = DateTimeFormatter.ofPattern(pattern)
        val givenDateTime = LocalDateTime.parse(givenDateString, formatter)
        
        val now = LocalDateTime.now(ZoneId.of("UTC"))
        val duration = Duration.between(givenDateTime, now)

        val days = duration.toDays()
        val hours = duration.toHours() % 24

        return "${days}d ${hours}h"
    }
}