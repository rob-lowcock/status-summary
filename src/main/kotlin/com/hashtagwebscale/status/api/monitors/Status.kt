package com.hashtagwebscale.status.api.monitors

enum class StatusType(val statusType: String) {
    SUCCESS("success"),
    WARNING("warning"),
    ERROR("error")
}

data class Status(val code: StatusType, val message: String, val url: String = "")