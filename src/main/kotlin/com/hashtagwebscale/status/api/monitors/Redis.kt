package com.hashtagwebscale.status.api.monitors

class Redis : Monitor {
    override fun getStatus(): Status {
        return StatusPage().parseStatusForUrl("https://j6ydyp75k0zx.statuspage.io/api/v2/summary.json")
    }
}