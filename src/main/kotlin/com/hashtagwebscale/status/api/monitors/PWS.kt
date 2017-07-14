package com.hashtagwebscale.status.api.monitors

class PWS : Monitor {
    override fun getStatus(): Status {
        return StatusPage().parseStatusForUrl("https://w03xnc15g1nv.statuspage.io/api/v2/summary.json")
    }
}