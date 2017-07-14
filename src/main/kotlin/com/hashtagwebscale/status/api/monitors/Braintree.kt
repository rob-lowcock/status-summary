package com.hashtagwebscale.status.api.monitors

class Braintree : Monitor {
    override fun getStatus(): Status {
        return StatusPage().parseStatusForUrl("https://03tltrdl3qkv.statuspage.io/api/v2/status.json")
    }
}