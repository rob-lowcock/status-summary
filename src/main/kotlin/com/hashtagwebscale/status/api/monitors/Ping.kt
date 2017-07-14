package com.hashtagwebscale.status.api.monitors

import khttp.get
import java.util.*

class Ping {

    fun pingURL(url: String): Status {
        val timeNow = Calendar.getInstance().timeInMillis
        val r = get(url)
        val resultTime = Calendar.getInstance().timeInMillis.minus(timeNow)

        var statusType = StatusType.SUCCESS
        var statusMessage = "All Systems Operational"
        if (r.statusCode != 200) {
            statusType = StatusType.ERROR
            statusMessage = "Error when getting page: " + r.statusCode.toString()
        } else if (resultTime > 600) {
            statusType = StatusType.WARNING
            statusMessage = "Slow response time: $resultTime ms"
        }

        return Status(statusType, statusMessage, url)
    }
}