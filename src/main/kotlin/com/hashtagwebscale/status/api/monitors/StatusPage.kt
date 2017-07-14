package com.hashtagwebscale.status.api.monitors

import khttp.get

class StatusPage {
    fun parseStatusForUrl(url: String): Status {
        val r = get(url)
        val result  = r.jsonObject
        val message = result.getJSONObject("status").getString("description")
        val indicator = result.getJSONObject("status").getString("indicator")
        val url = result.getJSONObject("page").getString("url")

        var status = StatusType.SUCCESS

        if (indicator.indexOf("major") > -1) {
            status = StatusType.ERROR
        } else if (indicator != "none") {
            status = StatusType.WARNING
        }

        return Status(status, message, url)
    }
}