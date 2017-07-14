package com.hashtagwebscale.status.api.monitors

class MonitorFactory {
    fun generate(service: String): Monitor? {
        when(service) {
            "braintree" -> return Braintree()
            "redis" -> return Redis()
            "papertrail" -> return Papertrail()
            "pws" -> return PWS()
            "stuart" -> return Stuart()
            else -> return null
        }
    }
}