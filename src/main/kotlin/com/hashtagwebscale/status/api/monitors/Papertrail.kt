package com.hashtagwebscale.status.api.monitors

class Papertrail : Monitor {
    override fun getStatus(): Status {
        return StatusPage().parseStatusForUrl("http://0n5jhb30j32t.statuspage.io/api/v2/status.json")
    }
}