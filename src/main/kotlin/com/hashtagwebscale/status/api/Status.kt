package com.hashtagwebscale.status.api

import com.hashtagwebscale.status.api.monitors.MonitorFactory

class Status {
    fun getStatusForService(service: String): String? {
        val factory = MonitorFactory()
        val monitor = factory.generate(service) ?: return null

        val status = monitor.getStatus()
        val statusType = status.code.statusType
        val statusMessage = status.message
        val url = status.url

        return "{ \"type\": \"$statusType\", \"message\": \"$statusMessage\", \"url\": \"$url\" }"
    }
}