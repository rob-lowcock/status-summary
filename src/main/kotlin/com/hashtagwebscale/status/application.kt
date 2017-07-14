package com.hashtagwebscale.status

import com.hashtagwebscale.status.api.Status
import spark.Spark.*

fun main(args: Array<String>) {
    val sysPort: String = System.getenv().get("PORT") ?: "4567"
    val status = Status()

    port(Integer.parseInt(sysPort))

    staticFiles.location("/dist")

    get("/api/:service") { req, res ->
        val output = status.getStatusForService(req.params("service"))
        if (!output.isNullOrEmpty()) {
            res.header("content-type", "application/json")
            output
        } else {
            res.status(404)
            "Not found"
        }
    }
}
