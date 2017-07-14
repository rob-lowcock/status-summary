package com.hashtagwebscale.status.api.monitors

interface Monitor {
    fun getStatus(): Status
}