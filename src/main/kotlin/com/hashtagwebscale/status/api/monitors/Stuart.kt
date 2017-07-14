package com.hashtagwebscale.status.api.monitors

import khttp.get

class Stuart : Monitor {
    override fun getStatus(): Status {
        val r = get("https://status.stuart.com/api/status.json")
        val result  = r.jsonObject
        val message = result.getJSONObject("body").getString("en")
        val indicator = result.getString("status")

        var status = StatusType.SUCCESS

        if (indicator.indexOf("bad") > -1) {
            status = StatusType.ERROR
        } else if (indicator != "good") {
            status = StatusType.WARNING
        }

        return Status(status, message, "https://status.stuart.com/api/messages.json")
    }
}